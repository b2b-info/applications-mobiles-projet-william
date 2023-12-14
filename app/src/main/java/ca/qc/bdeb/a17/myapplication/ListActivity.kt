package ca.qc.bdeb.a17.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        // TOOLBAR
        // Récupérer la référence de la Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        // Changer le label de la Toolbar
        toolbar.title = "Liste des livres"
    }
}