package com.techand.pagingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//https://api.stackexchange.com/2.3/answers?page=1&pagesize=50&site=stackoverflow
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}