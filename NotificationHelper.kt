package com.lionos

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationHelper(private val context: Context) {

    private val CHANNEL_ID = "lionos_channel"

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name = "LionOS Notifications"

            val descriptionText =
                "Canal oficial LionOS"

            val importance =
                NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(
                CHANNEL_ID,
                name,
                importance
            ).apply {

                description = descriptionText
            }

            val notificationManager =
                context.getSystemService(
                    Context.NOTIFICATION_SERVICE
                ) as NotificationManager

            notificationManager
                .createNotificationChannel(channel)
        }
    }

    fun showNotification(
        title: String,
        message: String
    ) {

        val intent =
            Intent(context, MainActivity::class.java)

        val pendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

        val builder =
            NotificationCompat.Builder(
                context,
                CHANNEL_ID
            )

                .setSmallIcon(R.drawable.lion_logo)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(
                    NotificationCompat.PRIORITY_DEFAULT
                )
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {

            notify(1, builder.build())
        }
    }
}