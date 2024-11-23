package com.example.android_lessons

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
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
     lateinit var button_login:Button
     lateinit var checkBox: CheckBox
     lateinit var progress:ProgressBar
     lateinit var contentlayout:LinearLayout
//     private val textWatcher:TextWatcher = object :SimpleTextWatcher(){
//         override fun afterTextChanged(p0: Editable?) {
//             Log.d("TextWatchertag","afterchanged $p0")
//             val input =p0.toString()
//             if (input.endsWith("@g")){ // doesnt work
//                 Log.d("TextWatchertag2","prog set text")
//                setText("${input}mail.com")
//             }
//         }
//
//         override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//             TODO("Not yet implemented")
//         }
//
//         override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//             TODO("Not yet implemented")
//         }
//     }
//    private fun setText(text:String){
//        login.removeTextChangedListener(textWatcher)
//        login.setText(text)
//        login.addTextChangedListener(textWatcher)
//    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         login = findViewById<TextInputEditText>(R.id.first)
         pass = findViewById<TextInputEditText>(R.id.second)
         desc = findViewById<TextInputEditText>(R.id.third)
        button_login = findViewById<Button>(R.id.button_log)
        checkBox = findViewById<CheckBox>(R.id.checkboxfield)
        contentlayout = findViewById(R.id.contentlayout)
        progress = findViewById(R.id.progress)
        val spanblestring = SpannableString("Принять условия конфиденциальности.")
        checkBox.text =spanblestring
        button_login.isEnabled = false
        checkBox.setOnCheckedChangeListener{_, isChecked ->
            button_login.isEnabled =isChecked
        }
        button_login.setOnClickListener {
            if (login.text?.contains("@gmail.com") == true){
        progress.visibility= View.VISIBLE
                //hidekeyboard or somthing more...
                hidekeyboard(login)
                contentlayout.visibility =View.GONE
                button_login.isEnabled= false
                Snackbar.make(button_login, "Loading...",Snackbar.LENGTH_SHORT).show()
                Handler(Looper.myLooper()!!).postDelayed({
                    contentlayout.visibility = View.VISIBLE
                    progress.visibility =View.GONE
                    button_login.isEnabled = true
                }, 3000)
            } else { Snackbar.make(button_login, "write correct login and pass",Snackbar.LENGTH_SHORT).show()}

        }

    }


}
fun AppCompatActivity.hidekeyboard(view: View){
    val imm = this.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken,0)
}
//abstract class SimpleTextWatcher:TextWatcher{
//    override fun afterTextChanged(p0: Editable?) {
//        TODO("Not yet implemented")
//    }
//}