package com.example.android_lessons

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

class DownloadImage (
    private val url: String,
    private val callback: ImageCallBack
    ): Thread(){
    override fun run() {
    try {
        val connection= URL(url).openConnection()
        connection.doInput= true
        connection.connect()
        connection.getInputStream().use {
            callback.success(BitmapFactory.decodeStream(it))
        }
        }catch (e:Exception){
            callback.failed()
        }
    }
}
interface ImageCallBack{
    fun success(decodeStream: Bitmap)
    fun failed()
}