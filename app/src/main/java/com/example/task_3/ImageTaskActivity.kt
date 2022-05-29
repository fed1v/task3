package com.example.task_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

class ImageTaskActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var editTextLink: EditText
    private lateinit var buttonLoadImage: Button
    private lateinit var buttonOpenFlagsTask: Button
    private lateinit var picassoBuilder: Picasso.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_task)

        initView()

        picassoBuilder = Picasso.Builder(this)
        picassoBuilder.listener { picasso, uri, exception ->
            Toast.makeText(this, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView() {
        image = findViewById(R.id.image)
        editTextLink = findViewById(R.id.editText_link)
        buttonLoadImage = findViewById(R.id.button_loadImage)
        buttonOpenFlagsTask = findViewById(R.id.button_openFlagsTask)

        image.setOnClickListener {
            val url = editTextLink.text.toString()
            loadImage(url)
        }

        buttonLoadImage.setOnClickListener {
            val url = editTextLink.text.toString()
            loadImage(url)
        }

        buttonOpenFlagsTask.setOnClickListener {
            openFlagTaskActivity()
        }
    }

    private fun openFlagTaskActivity() {
        val intent = Intent(this, FlagsTaskActivity::class.java)
        startActivity(intent)
    }

    private fun loadImage(url: String) {
        try {
            if (url.isNotBlank()) {
                picassoBuilder
                    .build()
                    .load(url)
                    .placeholder(R.drawable.ic_image_placeholder)
                    .error(R.drawable.ic_image_placeholder)
                    .into(image)
            } else {
                Toast.makeText(this, "Error: Empty url", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}