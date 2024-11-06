package com.example.list

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.Person
import java.util.jar.Attributes.Name

class Detail : AppCompatActivity() {
    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_DESC = "key_desc"
        const val KEY_IMAGE = "key_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Makanan>("DATA")
        Log.d("Detail Data", data?.name.toString())


        val name = intent.getStringExtra(KEY_NAME)
        val desc = intent.getStringExtra(KEY_DESC)
        val photo = intent.getIntExtra(KEY_IMAGE, 0)

        findViewById<TextView>(R.id.detail_name).text = name
        findViewById<TextView>(R.id.detail_desc).text = desc
        findViewById<ImageView>(R.id.detail_img).setImageResource(photo)
    }
}