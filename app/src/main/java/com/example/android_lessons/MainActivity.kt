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
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.imageload)

        Picasso.get().load(URL).centerCrop()
            .resize(720,1280)
            .placeholder(android.R.drawable.ic_media_pause)
            .error(android.R.drawable.ic_dialog_alert)
            .into(image)

    }

private companion object {
    const val  URL = "https://sun9-20.userapi.com/impf/c853528/v853528468/1c60b/3vtdaJa1oDY.jpg?size=1442x2160&quality=96&sign=ab1b455cff5f5f8bbf359a84773133bd&type=album"
}
}

