package com.example.notesapp.utilits

import android.content.Context
import android.content.SharedPreferences

object AppPreference {

    private const val INIT_USER = "initUser"
    private const val TYPE_DATABASE = "typeDatabase"
    private const val NAME_PREF = "preference"

    private lateinit var mPreference: SharedPreferences

    fun getPreference(context: Context): SharedPreferences {
        mPreference = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreference
    }

    fun setInitUser(init:Boolean) {
        mPreference.edit()
                .putBoolean(INIT_USER, init)
                .apply()
    }

    fun getInitUser() = mPreference.getBoolean(INIT_USER, false)

    fun setTypeDatabase(type: String) {
        mPreference.edit()
                .putString(TYPE_DATABASE, type)
                .apply()
    }

    fun getTypeDatabase() = mPreference.getString(TYPE_DATABASE, TYPE_ROOM).toString()

}