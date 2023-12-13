package ca.qc.bdeb.a17.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class BookLibrary : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_library)

        // Récupérer la référence de la Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        // Changer le label de la Toolbar
        toolbar.title = "Bibliothèque"
    }
}