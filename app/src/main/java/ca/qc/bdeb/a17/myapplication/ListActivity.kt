package ca.qc.bdeb.a17.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.qc.bdeb.a17.myapplication.DAO.Entity.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Liste des livres"
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)

        GlobalScope.launch(Dispatchers.IO) {
            val books = BookLibrary.database.bookDao().getAllBooks()

            withContext(Dispatchers.Main) {
                val adapter = BookAdapter(books)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@ListActivity)
            }
        }
    }
}