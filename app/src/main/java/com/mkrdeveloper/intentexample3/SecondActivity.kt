package com.mkrdeveloper.intentexample3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val edt_data = findViewById<EditText>(R.id.edt_data)
        val btn_send = findViewById<Button>(R.id.btn_send)


        btn_send.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", edt_data.text.toString())


            setResult(Activity.RESULT_OK , intent)

            finish()

        }
    }
}