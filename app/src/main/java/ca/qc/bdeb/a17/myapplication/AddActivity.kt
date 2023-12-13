package ca.qc.bdeb.a17.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import ca.qc.bdeb.a17.myapplication.SQL.MyDatabase

class AddActivity : AppCompatActivity() {

    lateinit var titleInput: EditText
    lateinit var authorInput: EditText
    lateinit var pagesInput: EditText
    lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        // TOOLBAR
        // Initialiser la toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        // Changer le label de la Toolbar
        toolbar.title = "Ajouter livre"

        // Initialiser les vues
        titleInput = findViewById(R.id.title_input)
        authorInput = findViewById(R.id.author_input)
        pagesInput = findViewById(R.id.pages_input)
        addButton = findViewById(R.id.add_button)

        // Définir le listener du bouton
        addButton.setOnClickListener {
            val myDB = MyDatabase(this@AddActivity)
            myDB.ajouterLivre(
                titleInput.text.toString().trim(),
                authorInput.text.toString().trim(),
                pagesInput.text.toString().trim().toInt()
            )
        }
    }
}