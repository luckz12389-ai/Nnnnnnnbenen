package com.wave.pc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnGameLibrary).setOnClickListener {
            startActivity(Intent(this, GameLibraryActivity::class.java))
        }

        findViewById<Button>(R.id.btnControlsEditor).setOnClickListener {
            startActivity(Intent(this, ControlEditorActivity::class.java))
        }

        findViewById<Button>(R.id.btnPhysicalController).setOnClickListener {
            startActivity(Intent(this, PhysicalControllerActivity::class.java))
        }
    }
}
