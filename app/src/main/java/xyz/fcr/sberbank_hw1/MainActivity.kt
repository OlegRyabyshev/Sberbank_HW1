package xyz.fcr.sberbank_hw1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

private lateinit var rusTextView: TextInputEditText
private lateinit var engTextView: TextInputEditText
private lateinit var btnTranslate: MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        rusTextView = findViewById(R.id.text_rus)
        engTextView = findViewById(R.id.text_eng)
        btnTranslate = findViewById(R.id.button_translate)

        btnTranslate.setOnClickListener {
            if (!leftFieldIsEmpty() && rightFieldIsEmpty()) {
                translateToEng()
            } else if (leftFieldIsEmpty() && !rightFieldIsEmpty()) {
                translateToRus()
            } else if (!leftFieldIsEmpty() && !rightFieldIsEmpty()) {
                Toast.makeText(this, "One field should be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun translateToEng() {
        var text = rusTextView.text.toString()

        for (i in russianFrom.indices) {
            text = text.replace(russianFrom[i], russianTo[i])
        }

        rusTextView.setText("")
        engTextView.setText(text)
    }

    private fun translateToRus() {
        var text = engTextView.text.toString()

        for (i in latinFrom.indices) {
            text = text.replace(latinFrom[i], latinTo[i])
        }

        engTextView.setText("")
        rusTextView.setText(text)
    }

    private fun leftFieldIsEmpty(): Boolean {
        if (rusTextView.text?.isEmpty() == true) return true
        return false
    }

    private fun rightFieldIsEmpty(): Boolean {
        if (engTextView.text?.isEmpty() == true) return true
        return false
    }
}