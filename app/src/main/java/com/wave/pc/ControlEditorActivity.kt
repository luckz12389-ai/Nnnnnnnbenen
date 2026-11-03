package com.wave.pc

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ControlEditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_editor)

        val btnSave = findViewById<Button>(R.id.btnSaveProfile)
        btnSave.setOnClickListener {
            val profile = ControlProfile(
                profileName = "Perfil Padrão Roblox",
                packageName = "com.roblox.client",
                btnWPos = Pair(100f, 200f),
                btnSpacePos = Pair(500f, 700f),
                opacity = 0.8f,
                lastModified = System.currentTimeMillis()
            )
            ProfileManager.saveProfile(this, profile)
            Toast.makeText(this, "Perfil salvo localmente com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }
}
