package com.example.pizzaapps

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class BaseApplication: Application() {

    companion object{ //static
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_2_ID = "channel1"
    }

    private fun createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "Ini sample Channel 1"

            val channel2 = NotificationChannel(
                CHANNEL_2_ID,
                "channel 2",
                NotificationManager.IMPORTANCE_LOW
            )
            channel1.description = "Ini sample Channel 2"

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
        }
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }
}