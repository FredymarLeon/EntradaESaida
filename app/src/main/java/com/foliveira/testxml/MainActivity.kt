package com.foliveira.testxml

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var count = 0
    var btnAdd: Button? = null
    var btnRemove: Button? = null
    var tvCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAdd = findViewById(R.id.btnAdd)
        btnRemove = findViewById(R.id.btnRemove)
        tvCount = findViewById(R.id.tvCount)

        btnAdd?.setOnClickListener {
            count++
            tvCount?.text = count.toString()
        }

        btnRemove?.setOnClickListener {
            count--
            tvCount?.text = count.toString()
        }

        count = savedInstanceState?.getInt("count") ?: 0
        tvCount?.text = count.toString()

        Log.d("MainActivity", "Executei o método onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", count)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "Executei o método onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "Executei o método onResume")
    }

    override fun onPause() {
        Log.d("MainActivity", "Executei o método onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "Executei o método onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "Executei o método onDestroy")
        super.onDestroy()
    }
}