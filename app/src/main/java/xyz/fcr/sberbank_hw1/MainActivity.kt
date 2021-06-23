package xyz.fcr.sberbank_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val textView: TextView = findViewById(R.id.TextView)
        textView.apply {
            text = context.getString(R.string.hello_sber)
            textSize = 30F
        }
    }
}