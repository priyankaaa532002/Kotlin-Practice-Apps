package com.example.sharedpreferences

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //NOTIFICATION  step 1
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        val sharedPref = getSharedPreferences("myPref",Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val isAdult = cbAdult.isChecked

            editor.apply{
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult", isAdult)
                apply()//apply over commit
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name",null)
            val age = sharedPref.getInt("age",0)
            val isAdult = sharedPref.getBoolean("isAdult",false)

            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked = isAdult
        }
        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Notification aaya")
            .setContentText("Hi this is content")
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        btnNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID,notification)
        }
    }
    //NOTIFICATION  step 2
    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}