package com.andrewKarachun0304.tmshomeworkandroid.hw10.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
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
import kotlin.math.roundToInt

private const val WIDGETS_ID_KEY = "widgetIdsKey"

class WeatherAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val remoteViews = RemoteViews(context.packageName, R.layout.weather_app_widget)
        val actionUpdateWidget = Intent()
        actionUpdateWidget.apply {
            putExtra(WIDGETS_ID_KEY, appWidgetIds)
            action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        }
        val updateWidget = PendingIntent.getBroadcast(
            context,
            101,
            actionUpdateWidget,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        remoteViews.setOnClickPendingIntent(R.id.widget_layout, updateWidget)
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)

        // There may be multiple widgets active, so update all of them
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
        val appWidgetIds = intent?.getIntArrayExtra(WIDGETS_ID_KEY)
        val appWidgetManager = AppWidgetManager.getInstance(context)
        if (appWidgetIds != null && context != null) {
            for (appWidgetId in appWidgetIds) {
                onUpdate(context, appWidgetManager, appWidgetIds)
            }
        }
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    // Construct the RemoteViews object
    val remoteViews = RemoteViews(context.packageName, R.layout.weather_app_widget)

    launchIO {
        val currentWeather = getWeather(widgetText)
        if (currentWeather != null) {
            remoteViews.apply {
                setViewVisibility(R.id.progress_update_pb, View.VISIBLE)
                appWidgetManager.updateAppWidget(appWidgetId, this)
                setTextViewText(R.id.description_tv, currentWeather.description)
                setTextViewText(R.id.max_temp_tv, "${currentWeather.temp.roundToInt()}\u2103")
                setTextViewText(R.id.city_name_tv, currentWeather.cityName)
                setViewVisibility(R.id.progress_update_pb, View.INVISIBLE)
                setImageViewBitmap(
                    R.id.weather_icon_iv,
                    Picasso.get()
                        .load("http://openweathermap.org/img/wn/${currentWeather.iconId}@2x.png")
                        .get()
                )
                appWidgetManager.updateAppWidget(appWidgetId, this)
            }
        }
    }
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