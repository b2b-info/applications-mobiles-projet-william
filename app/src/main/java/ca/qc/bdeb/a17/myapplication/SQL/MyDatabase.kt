package ca.qc.bdeb.a17.myapplication.SQL
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class MyDatabase(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "Bibliothèque.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "my_library"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_TITLE = "book_title"
        private const val COLUMN_AUTHOR = "book_author"
        private const val COLUMN_PAGES = "book_pages"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE $TABLE_NAME " +
                "($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_TITLE TEXT, " +
                "$COLUMN_AUTHOR TEXT, " +
                "$COLUMN_PAGES INTEGER);"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun ajouterLivre(titre: String, auteur: String, pages: Int) {
        try {
            writableDatabase.use { db ->
                val cv = ContentValues()

                cv.put(COLUMN_TITLE, titre)
                cv.put(COLUMN_AUTHOR, auteur)
                cv.put(COLUMN_PAGES, pages)

                val resultat = db.insert(TABLE_NAME, null, cv)

                if (resultat == -1L) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Ajouté avec succès", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.e("MyDatabase", "Erreur d'insertion: ${e.message}")
            Toast.makeText(context, "Erreur d'insertion", Toast.LENGTH_SHORT).show()
        }
    }

}
