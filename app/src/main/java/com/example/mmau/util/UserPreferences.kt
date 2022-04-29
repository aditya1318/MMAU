package com.example.mmau.util

import android.content.Context

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import java.util.prefs.Preferences


class UserPreferences (
    context: Context
        )
{
    private val Context._dataStore by preferencesDataStore("Key")

    private val dataStore : DataStore<androidx.datastore.preferences.core.Preferences> = context._dataStore

 val authToken:Flow<String?>
 get() = dataStore.data.map { preference ->
      preference[KEY_AUTH]
 }
suspend fun  saveAuthToken(authToken:String) {
    dataStore.edit { preference ->

       preference[KEY_AUTH] = authToken
    }
}

    companion object {
        private val KEY_AUTH = stringPreferencesKey("key_auth")
    }
}
