package com.example.lab4

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class DetailActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val person = intent.getParcelableExtra<Person>("PERSON")

        findViewById<ImageView>(R.id.ivPhoto).setImageResource(person?.photoRes ?: R.drawable.avatar_default)
        findViewById<TextView>(R.id.tvName).text = person?.name
        findViewById<TextView>(R.id.tvAge).text = "Возраст: ${person?.age}"
        findViewById<TextView>(R.id.tvProfession).text = "Профессия: ${person?.profession}"
        findViewById<TextView>(R.id.tvBio).text = person?.bio

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}