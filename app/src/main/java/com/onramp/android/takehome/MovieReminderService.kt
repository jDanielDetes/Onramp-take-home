package com.onramp.android.takehome

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Movie
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.net.URI

class MovieReminderService: Service() {

private val CHANNEL_ID= "two"



    companion object{
        fun startService(context: Context, message:String) {
            val startIntent = Intent(context,MovieReminderService::class.java)
            startIntent.putExtra("input", message)
            ContextCompat.startForegroundService(context,startIntent)
        }
        fun stopService(context: Context){
            val stopIntent = Intent(context,MovieReminderService::class.java)
            context.stopService(stopIntent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra("input")
        createNotificationChannel()
        val notificationIntent = Intent(this,movie_details::class.java)
        val pendingIntent= PendingIntent.getActivity(
                this,0,notificationIntent,0
        )



        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Movie Radar Reminder!")
                .setContentText(input)
                .setSmallIcon(R.drawable.placeholder)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(1,notification)
        return START_NOT_STICKY

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    private fun createNotificationChannel() {
        val serviceChannel = NotificationChannel(CHANNEL_ID, " Foreground",NotificationManager.IMPORTANCE_HIGH).apply{
            lightColor= Color.RED
            enableLights(true)
        }

        val manager = getSystemService(NotificationManager::class.java)
        manager!!.createNotificationChannel(serviceChannel)
    }



}