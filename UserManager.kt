package com.lionos

import android.content.Context

class UserManager(context: Context) {

    // =====================================
    // SHARED PREFERENCES
    // =====================================

    private val prefs =
        context.getSharedPreferences(
            "LionUsers",
            Context.MODE_PRIVATE
        )

    // =====================================
    // GUARDAR USUARIO
    // =====================================

    fun saveUser(username: String) {

        prefs.edit()
            .putString(
                "current_user",
                username
            )
            .apply()
    }

    // =====================================
    // OBTENER USUARIO
    // =====================================

    fun getUser(): String {

        return prefs.getString(
            "current_user",
            "Admin"
        ) ?: "Admin"
    }

    // =====================================
    // ACTIVAR DEVELOPER MODE
    // =====================================

    fun enableDeveloperMode() {

        prefs.edit()
            .putBoolean(
                "developer_mode",
                true
            )
            .apply()
    }

    // =====================================
    // VERIFICAR DEVELOPER MODE
    // =====================================

    fun isDeveloperMode(): Boolean {

        return prefs.getBoolean(
            "developer_mode",
            false
        )
    }
}