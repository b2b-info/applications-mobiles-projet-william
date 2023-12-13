package ca.qc.bdeb.a17.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ca.qc.bdeb.a17.myapplication.DAO.Entity.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            val myDB = BookLibrary.database


            // Utiliser une coroutine pour appeler la fonction suspendue du DAO
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    myDB.bookDao().insertBook(
                        Book(
                            title = titleInput.text.toString().trim(),
                            author = authorInput.text.toString().trim(),
                            pages = pagesInput.text.toString().trim().toInt()
                        )
                    )

                    // Si l'insertion réussit, affichez un toast dans le thread principal
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@AddActivity, "Livre ajouté avec succès", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    // En cas d'échec, affichez un toast d'erreur dans le thread principal
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@AddActivity, "Échec de l'ajout du livre", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}