package com.andrewKarachun0304.tmshomeworkandroid.hw9

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.IBinder
import com.andrewKarachun0304.tmshomeworkandroid.R

class TimerService : Service() {

    override fun onCreate() {
        super.onCreate()

        val activityIntent = Intent(this, HomeWork9Activity::class.java)

        val pendingIntent =
            PendingIntent.getActivity(
                this,
                1,
                activityIntent,
                PendingIntent.FLAG_CANCEL_CURRENT
            )

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notification = Notification.Builder(this, NOTIFICATION_CHANEL_ID)
                .setContentTitle("Timer")
                .setContentText("Timer is finish")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(
                    Notification.Action.Builder(
                        Icon.createWithResource(this, R.drawable.ic_launcher_foreground),
                        "Start activity",
                        pendingIntent
                    ).build()
                )
            .build()
            startForeground(1, notification)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}