package com.wave.pc

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameLibraryActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var appList: List<android.content.pm.ApplicationInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.btnGameLibrary)
        val pm: PackageManager = packageManager
        appList = pm.getInstalledApplications(PackageManager.GET_META_DATA)

        val appNames = appList.map { pm.getApplicationLabel(it).toString() }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, appNames)

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedApp = appList[position]
            val appName = pm.getApplicationLabel(selectedApp).toString()
            val packageName = selectedApp.packageName

            if (packageName == "com.roblox.client") {
                Toast.makeText(this, "Roblox selecionado! Perfil carregado.", Toast.LENGTH_LONG).show()
            }

            val launchIntent = pm.getLaunchIntentForPackage(packageName)
            if (launchIntent != null) {
                Toast.makeText(this, "Abrindo $appName", Toast.LENGTH_SHORT).show()
                startActivity(launchIntent)
            } else {
                Toast.makeText(this, "Não foi possível abrir este aplicativo diretamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
