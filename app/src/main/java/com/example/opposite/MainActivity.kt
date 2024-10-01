package com.example.opposite

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var buttonResult: Button
    private lateinit var result: TextView
    private lateinit var count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.editText)
        buttonResult = findViewById(R.id.buttonResult)
        result = findViewById(R.id.result)
        count = findViewById(R.id.count)
    }
    @SuppressLint("SetTextI18n")
    fun onClickResult(view: View){
        val str = editText.text
        result.text = "Результат: ${str.reversed()}"
        count.text = "Количество символов: ${str.replace("\\s".toRegex(), "").length}"
    }

}
