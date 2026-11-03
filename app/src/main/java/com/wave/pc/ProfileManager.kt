package com.wave.pc

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

data class ControlProfile(
    val profileName: String,
    val packageName: String,
    val btnWPos: Pair<Float, Float>,
    val btnSpacePos: Pair<Float, Float>,
    val opacity: Float,
    val lastModified: Long
)

object ProfileManager {
    private const val PREF_NAME = "WavePCProfiles"

    fun saveProfile(context: Context, profile: ControlProfile) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val gson = Gson()
        val json = gson.toJson(profile)
        prefs.edit().putString(profile.packageName, json).apply()
    }

    fun getProfile(context: Context, packageName: String): ControlProfile? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(packageName, null) ?: return null
        return Gson().fromJson(json, ControlProfile::class.java)
    }
}
