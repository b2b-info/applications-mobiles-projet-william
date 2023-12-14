package ca.qc.bdeb.a17.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import ca.qc.bdeb.a17.myapplication.DAO.Database.AppDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookLibrary : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var add_button: FloatingActionButton

    companion object {
        lateinit var database: AppDatabase
    }

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
        recyclerView = findViewById(R.id.recyclerView)
        add_button = findViewById(R.id.add_button)
        add_button.setOnClickListener {
            val intent = Intent(this@BookLibrary, AddActivity::class.java)
            startActivity(intent)
        }
        // Initialisez la base de données Room
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Bibliotheque")
            .build()
    }

    // MENU
    // Initialiser le menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //la liste
            R.id.list_activity -> openListActivity()
            //pour delete la bd
            R.id.clear_db -> clearDatabase()
            //pour la commandite de la bibliothèque :)
            R.id.commandit_activity -> openCommanditeActivity()
            R.id.search_book -> openOnlineSearch()

        }
        return super.onOptionsItemSelected(item)
    }

    private fun openOnlineSearch() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }


    private fun openListActivity() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    private fun clearDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                database.bookDao().deleteAllBooks()
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@BookLibrary, "Base de donnée vidé avec succès", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@BookLibrary, "Erreur dans la suppression des données", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun openCommanditeActivity()
    {
        val intent = Intent(this, CommanditeActivity::class.java)
        startActivity(intent)
    }
}


