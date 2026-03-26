package com.fitmind30.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository(private val context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    suspend fun saveUserData(userId: String, userData: Map<String, Any>) {
        // Save to SharedPreferences
        val editor = sharedPreferences.edit() 
        for ((key, value) in userData) {
            editor.putString(key, value.toString())
        }
        editor.apply()

        // Save to Firebase
        firestore.collection("users").document(userId).set(userData).await()
    }
   
    suspend fun getUserData(userId: String): Map<String, Any>? {
        // Try to get data from SharedPreferences first
        val sharedPrefsData = mutableMapOf<String, Any>()
        for (key in sharedPreferences.all.keys) {
            sharedPrefsData[key] = sharedPreferences.getString(key, "") ?: ""
        }

        // If data not found in SharedPreferences, retrieve from Firebase
        return if (sharedPrefsData.isNotEmpty()) {
            sharedPrefsData
        } else {
            val document = firestore.collection("users").document(userId).get().await()
            if (document.exists()) {
                document.data ?: emptyMap()
            } else {
                null
            }
        }
    }
}