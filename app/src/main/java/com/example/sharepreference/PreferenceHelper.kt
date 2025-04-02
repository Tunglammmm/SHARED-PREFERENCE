package com.example.sharedprefs

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {
    private val PREFS_NAME = "user_prefs"
    private val NAME_KEY = "name"
    private val PASSWORD_KEY = "password"

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)


    fun saveUser(name: String, password: String) {
        val editor = prefs.edit()
        editor.putString(NAME_KEY, name)
        editor.putString(PASSWORD_KEY, password)
        editor.apply()
    }


    fun getUser(): Pair<String?, String?> {
        val name = prefs.getString(NAME_KEY, null)
        val password = prefs.getString(PASSWORD_KEY, null)
        return Pair(name, password)
    }


    fun clearUser() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}
