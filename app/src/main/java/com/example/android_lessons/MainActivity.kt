package com.example.android_lessons

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toAdaptiveIcon
import androidx.core.graphics.drawable.toIcon
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageload)
        image.setImageResource(R.drawable.ic_geg)
        val loadimage = DownloadImage(URL,object: ImageCallBack{
            override fun success(bitmap: Bitmap) {
                image.setImageBitmap(bitmap)
            }

            override fun failed() {
                Snackbar.make(image,"failed",Snackbar.LENGTH_SHORT).show()
            }

        })
    loadimage.start()
    }

private companion object {
    const val  URL = "https://static.wikia.nocookie.net/anime-characters-fight/images/3/31/Satoru_5003.png/revision/latest?cb=20210404115448&path-prefix=ru"
}
}

