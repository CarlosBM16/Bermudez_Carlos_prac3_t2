package com.example.ejercicio3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio1.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.games)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val angryBirds = findViewById<GameView>(R.id.angryBirds)
        val dragonFly = findViewById<GameView>(R.id.dragonFly)
        val hillClimbing = findViewById<GameView>(R.id.hillClimbing)
        val radiantDefense = findViewById<GameView>(R.id.radiantDefense)
        val pocketSoccer = findViewById<GameView>(R.id.pocketSoccer)
        val ninjaJump = findViewById<GameView>(R.id.ninjaJump)
        val airControl = findViewById<GameView>(R.id.airControl)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val gameViews = listOf(
                angryBirds, dragonFly, hillClimbing,
                radiantDefense, pocketSoccer, ninjaJump, airControl
            )
            val checkedGames = gameViews.filter { it.isChecked() }
                                        .map { it.getText() }

            if (checkedGames.isEmpty()) {
                Toast.makeText(this, "No hay juegos seleccionados", Toast.LENGTH_SHORT).show()
            } else {
                val message = checkedGames.joinToString(", ")
                Toast.makeText(this, "Juegos seleccionados: $message", Toast.LENGTH_LONG).show()
            }
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