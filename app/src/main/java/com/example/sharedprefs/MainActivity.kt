 package com.example.sharedprefs


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

 class MainActivity : AppCompatActivity() {


     val btnSavePreferences by lazy { findViewById<Button>(R.id.btnSave) }

     val sw_pref1 by lazy {findViewById<Switch>(R.id.sw_pref1)}
     val sw_pref2 by lazy {findViewById<Switch>(R.id.sw_pref2)}
     val sw_pref3 by lazy {findViewById<Switch>(R.id.sw_pref3)}
     val sw_pref4 by lazy {findViewById<Switch>(R.id.sw_pref4)}
     val sw_pref5 by lazy {findViewById<Switch>(R.id.sw_pref5)}



     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
         val editor = sharedPreferences.edit()

        loadPreferences(sharedPreferences)


     btnSavePreferences.setOnClickListener{
         savePreferences(editor)
     }


 }


     private fun savePreferences(editor: SharedPreferences.Editor) {

         editor.apply{

             putBoolean("BOOLEAN_KEY_1",sw_pref1.isChecked)
             putBoolean("BOOLEAN_KEY_2",sw_pref2.isChecked)
             putBoolean("BOOLEAN_KEY_3",sw_pref3.isChecked)
             putBoolean("BOOLEAN_KEY_4",sw_pref4.isChecked)
             putBoolean("BOOLEAN_KEY_5",sw_pref5.isChecked)
             apply()
         }
     }

     private fun loadPreferences(sharedPreferences: SharedPreferences) {

         val pref1 = sharedPreferences.getBoolean("BOOLEAN_KEY_1",false)
         val pref2 = sharedPreferences.getBoolean("BOOLEAN_KEY_2",false)
         val pref3 = sharedPreferences.getBoolean("BOOLEAN_KEY_3",false)
         val pref4 = sharedPreferences.getBoolean("BOOLEAN_KEY_4",false)
         val pref5 = sharedPreferences.getBoolean("BOOLEAN_KEY_5",false)

         sw_pref1.isChecked = pref1
         sw_pref2.isChecked = pref2
         sw_pref3.isChecked = pref3
         sw_pref4.isChecked = pref4
         sw_pref5.isChecked = pref5

    }
 }