package com.ahmad.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmad.mvvm_retrofit.ui.WisataFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,WisataFragment()).commit()
    }
}
