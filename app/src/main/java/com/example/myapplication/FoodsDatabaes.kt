package com.example.myapplication

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import models.FoodModel

private const val SHERAD_PREFERENCES_KEY = "SHERAD_PREFERENCES_KEY"
private const val NOTES_SHARED_PRIF = "NOTES_SHARED_PRIF"

class FoodsDatabaes(
    private val context: Context,
) {
    private val sheradPreferencas = context.getSharedPreferences(
        SHERAD_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun getAllNote(): List<FoodModel> {
        val gson = Gson()
        val json = sheradPreferencas.getString(NOTES_SHARED_PRIF, null)
        val type = object : TypeToken<ArrayList<FoodModel?>?>() {}.type
        val noteList = gson.fromJson<List<FoodModel>>(json, type)
        return noteList ?: emptyList()
    }

    fun saveNote(notesModel: FoodModel) {
        val notes = getAllNote().toMutableList()
        notes.add(0, notesModel)
        val notesGson = Gson().toJson(notes)
        sheradPreferencas
            .edit()
            .putString(NOTES_SHARED_PRIF, notesGson)
            .apply()
    }

}