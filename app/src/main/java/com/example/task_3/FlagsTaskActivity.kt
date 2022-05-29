package com.example.task_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FlagsTaskActivity : AppCompatActivity() {

    private lateinit var buttonOpenImageTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags_task)

        initView()
    }

    private fun initView() {
        buttonOpenImageTask = findViewById(R.id.button_openImageTask)
        buttonOpenImageTask.setOnClickListener {
            openImageTaskActivity()
        }
    }

    private fun openImageTaskActivity() {
        val intent = Intent(this, ImageTaskActivity::class.java)
        startActivity(intent)
    }
}