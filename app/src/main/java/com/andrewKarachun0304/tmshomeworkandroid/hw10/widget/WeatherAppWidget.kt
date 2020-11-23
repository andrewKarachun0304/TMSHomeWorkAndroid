package com.andrewKarachun0304.tmshomeworkandroid.hw10.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.RemoteViews
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw10.entity.CurrentWeather
import com.andrewKarachun0304.tmshomeworkandroid.hw10.mappers.WeatherMapper
import com.andrewKarachun0304.tmshomeworkandroid.hw10.retrofit.RetrofitWeatherFactory
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchIO
import com.squareup.picasso.Picasso
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

private const val WIDGET_REQUEST_CODE = 2121

class WeatherAppWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        val appWidgetManager = AppWidgetManager.getInstance(context)
        if (context != null) {
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(
                    context,
                    WeatherAppWidget::class.java
                )
            )
            if (appWidgetIds != null) {
                for (appWidgetId in appWidgetIds) {
                    updateAppWidget(context, appWidgetManager, appWidgetId)
                }
            }
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    // Construct the RemoteViews object
    val remoteViews = RemoteViews(context.packageName, R.layout.weather_app_widget)
    addWidgetClickListener(context, remoteViews)

    launchIO {
        with(remoteViews) {
            setViewVisibility(R.id.progress_update_pb, View.VISIBLE)
            appWidgetManager.updateAppWidget(appWidgetId, this)
            delay(1000)
            getWeather(loadTitlePref(context, appWidgetId))?.let { currentWeather ->
                setTextViewText(R.id.description_tv, currentWeather.description)
                setTextViewText(R.id.max_temp_tv, "${currentWeather.temp.roundToInt()}\u2103")
                setTextViewText(R.id.city_name_tv, currentWeather.cityName)
                setImageViewBitmap(
                    R.id.weather_icon_iv,
                    Picasso.get()
                        .load("http://openweathermap.org/img/wn/${currentWeather.iconId}@2x.png")
                        .get()
                )
            }
            setViewVisibility(R.id.progress_update_pb, View.INVISIBLE)
            appWidgetManager.updateAppWidget(appWidgetId, this)
        }
    }
}

private fun addWidgetClickListener(context: Context, remoteViews: RemoteViews) {
    val actionUpdateWidget = Intent(context, WeatherAppWidget::class.java)
    actionUpdateWidget.apply {
        action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
    }
    val updateWidget = PendingIntent.getBroadcast(
        context,
        WIDGET_REQUEST_CODE,
        actionUpdateWidget,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
    remoteViews.setOnClickPendingIntent(R.id.widget_layout, updateWidget)
}

private suspend fun getWeather(cityName: String): CurrentWeather? {
    val retrofit = RetrofitWeatherFactory.getInstance()
    val response = retrofit.getWeatherInfoAsync(cityName).await()
    return if (response.isSuccessful) {
        WeatherMapper.parse(response.body())
    } else {
        null
    }
}