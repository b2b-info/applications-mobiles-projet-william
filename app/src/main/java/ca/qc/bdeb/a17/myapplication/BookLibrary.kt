package ca.qc.bdeb.a17.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BookLibrary : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var add_button: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_library)

        // TOOLBAR
        // Récupérer la référence de la Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        // Changer le label de la Toolbar
        toolbar.title = "Bibliothèque"
        setSupportActionBar(toolbar)  // Ajouter cette ligne pour configurer la Toolbar comme ActionBar

        // DATABASE
        // Ajout du recycler view et du add button
        recyclerView = findViewById(R.id.recyclerView)
        add_button = findViewById(R.id.add_button)
        add_button.setOnClickListener {
            val intent = Intent(this@BookLibrary, AddActivity::class.java)
            startActivity(intent)
        }
    }

    // MENU
    // Initialiser le menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}


