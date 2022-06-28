package com.mkrdeveloper.intentexample3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var resultText = ""

    val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult? ->

        if (result?.resultCode == Activity.RESULT_OK){
            resultText = result.data?.getStringExtra("data").toString()

            val txt_result = findViewById<TextView>(R.id.textView)
            txt_result.text = resultText
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btn_next = findViewById<Button>(R.id.btn_next)


        btn_next.setOnClickListener {


            val intent = Intent(this, SecondActivity::class.java)

            resultContract.launch(intent)

        }
    }
}