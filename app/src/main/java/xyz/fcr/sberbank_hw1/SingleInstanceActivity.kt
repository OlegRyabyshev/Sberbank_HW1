package xyz.fcr.sberbank_hw1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

private var number: Int = 0
private const val NUMBER_TAG = "Number tag"

class SingleInstanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        number = intent.getIntExtra(NUMBER_TAG, 0)

        //Setting up text views
        val nameTextView: TextView = findViewById(R.id.name)
        nameTextView.text = getString(R.string.single_instance)

        val numberTextView: TextView = findViewById(R.id.number)
        val text = "in another task"
        numberTextView.text = text


        //Setting up buttons
        val buttonStandard: MaterialButton = findViewById(R.id.button_standard)
        val buttonSingleTop: MaterialButton = findViewById(R.id.button_single_top)
        val buttonSingleTask: MaterialButton = findViewById(R.id.button_single_task)
        val buttonSingleInstance: MaterialButton = findViewById(R.id.button_single_instance)

        buttonStandard.setOnClickListener {
            val intent = Intent(this, StandardActivity::class.java).apply {
                putExtra(NUMBER_TAG, number)
            }
            startActivity(intent)
        }

        buttonSingleTop.setOnClickListener {
            val intent = Intent(this, SingleTopActivity::class.java).apply {
                putExtra(NUMBER_TAG, number)
            }
            startActivity(intent)
        }

        buttonSingleTask.setOnClickListener {
            val intent = Intent(this, SingleTaskActivity::class.java).apply {
                putExtra(NUMBER_TAG, number)
            }
            startActivity(intent)
        }

        buttonSingleInstance.setOnClickListener {
            val intent = Intent(this, SingleInstanceActivity::class.java).apply {
                putExtra(NUMBER_TAG, number)
            }
            startActivity(intent)
        }
    }
}