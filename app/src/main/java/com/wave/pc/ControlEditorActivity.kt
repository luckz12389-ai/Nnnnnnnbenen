package com.wave.pc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ControlEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Editor de Controles aberto.", Toast.LENGTH_SHORT).show()
    }
}
