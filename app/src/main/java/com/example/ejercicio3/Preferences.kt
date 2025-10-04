package com.example.ejercicio3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio1.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.preferences)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val selectedRadioId = radioGroup.checkedRadioButtonId
            if (selectedRadioId == -1) {
                Toast.makeText(this, "No has pulsado ninguna opción", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButton = findViewById<RadioButton>(selectedRadioId)
            val juegoSeleccionado = selectedRadioButton.text

            val puntuacionSeek = seekBar.progress
            val puntuacionStars = ratingBar.rating

            val mensaje = "Juego: $juegoSeleccionado\nSeekBar: $puntuacionSeek\nRatingBar: $puntuacionStars"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        }
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
        return super.onOptionsItemSelected(item)
    }
}