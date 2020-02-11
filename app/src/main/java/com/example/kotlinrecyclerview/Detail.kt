package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val auth = intent.getStringExtra("auth")
        val image = intent.getStringExtra("image")

        textView1.text = title
        textView2.text = auth

        Glide.with(this)
            //.applyDefaultRequestOptions(requestOptions)
            .load(image)
            .into(imageView2)
    }
}
