package com.example.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio1.R
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val jugador = findViewById(R.id.button1) as Button
        jugador.setOnClickListener { lanzarNewPlayer() }

        val preferences = findViewById(R.id.button2) as Button
        preferences.setOnClickListener { lanzarPreferences() }

        val play = findViewById(R.id.button) as Button
        play.setOnClickListener { lanzarPlay() }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }
    fun lanzarNewPlayer() {
        val actividad = Intent(this, NewPlayer::class.java)
        startActivity(actividad)
    }

    fun lanzarPreferences() {
        val actividad = Intent(this, Preferences::class.java)
        startActivity(actividad)
    }

    fun lanzarPlay() {
        val actividad = Intent(this, Games::class.java)
        startActivity(actividad)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Búsqueda", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_settings) {
            val intent = Intent(this, Filters::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}