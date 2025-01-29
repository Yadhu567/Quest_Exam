package com.example.examapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class NewsMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.news_main_activity_layout)

        val edittext1 = findViewById<EditText>(R.id.edittext1)

        val edittext2 = findViewById<EditText>(R.id.edittext2)

        val btn = findViewById<Button>(R.id.btn1)

        val intent = Intent(this, NewsResultActivity::class.java)

        btn.setOnClickListener {
            val source = edittext1.text.toString()
            val country = edittext2.text.toString()

            intent.putExtra("source", source)
            intent.putExtra("country", country)

            startActivity(intent)
        }
    }
}
