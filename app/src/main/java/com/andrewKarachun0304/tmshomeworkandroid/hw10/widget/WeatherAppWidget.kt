package com.andrewKarachun0304.tmshomeworkandroid.hw10.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.RemoteViews
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw10.entity.CurrentWeather
import com.andrewKarachun0304.tmshomeworkandroid.hw10.mappers.WeatherMapper
import com.andrewKarachun0304.tmshomeworkandroid.hw10.retrofit.RetrofitWeatherFactory
import com.andrewKarachun0304.tmshomeworkandroid.hw7.utils.launchIO
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.math.roundToInt

private const val WIDGETS_ID_KEY = "widgetIdsKey"
private const val WIDGET_ACTION_CLICK =
    "com.andrewKarachun0304.tmshomeworkandroid.hw10.ACTION_CLICK"
private const val WIDGET_REQUEST_CODE = 2121

class WeatherAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        Log.e("TAG", "onUpdate")
        val remoteViews = RemoteViews(context.packageName, R.layout.weather_app_widget)
        val actionUpdateWidget = Intent(context, WeatherAppWidget::class.java)
        actionUpdateWidget.apply {
            putExtra(WIDGETS_ID_KEY, appWidgetIds)
            action = WIDGET_ACTION_CLICK
        }
        val updateWidget = PendingIntent.getBroadcast(
            context,
            WIDGET_REQUEST_CODE,
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
        Log.e("TAG", "onReceive")
        val appWidgetIds = intent?.getIntArrayExtra(WIDGETS_ID_KEY)
        val appWidgetManager = AppWidgetManager.getInstance(context)
        Log.e("TAG", "appWidgetIds: ${appWidgetIds}")
        if (appWidgetIds != null && context != null) {
            onUpdate(context, appWidgetManager, appWidgetIds)

        }
    }
}
    internal fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        Log.e("TAG", "updateAppWidget start")
        // Construct the RemoteViews object
        val remoteViews = RemoteViews(context.packageName, R.layout.weather_app_widget)

        launchIO {
            with(remoteViews) {
                setViewVisibility(R.id.progress_update_pb, View.VISIBLE)
                appWidgetManager.updateAppWidget(appWidgetId, this)
                getWeather(loadTitlePref(context, appWidgetId))?.let { currentWeather ->
                    delay(1000)
                    setTextViewText(R.id.description_tv, currentWeather.description)
                    withContext(Dispatchers.Main){
                        Log.e("TAG", currentWeather.cityName)
                    }
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
            Log.e("TAG", "updateAppWidget end")
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