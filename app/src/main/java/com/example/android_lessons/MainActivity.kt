package com.example.android_lessons

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toAdaptiveIcon
import androidx.core.graphics.drawable.toIcon
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
     lateinit var login:TextInputEditText
     lateinit var pass:TextInputEditText
     lateinit var desc:TextInputEditText


     private val textWatcher:TextWatcher = object :SimpleTextWatcher(){
         override fun afterTextChanged(p0: Editable?) {
             Log.d("TextWatchertag","afterchanged $p0")
             val input =p0.toString()
             if (input.endsWith("@g")){ // doesnt work
                 Log.d("TextWatchertag2","prog set text")
                setText("${input}mail.com")
             }
         }

         override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
             TODO("Not yet implemented")
         }

         override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
             TODO("Not yet implemented")
         }
     }
    private fun setText(text:String){
        login.removeTextChangedListener(textWatcher)
        login.setText(text)
        login.addTextChangedListener(textWatcher)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         login = findViewById<TextInputEditText>(R.id.first)
         pass = findViewById<TextInputEditText>(R.id.second)
         desc = findViewById<TextInputEditText>(R.id.third)
    }


}
abstract class SimpleTextWatcher:TextWatcher{
    override fun afterTextChanged(p0: Editable?) {
        TODO("Not yet implemented")
    }

}
