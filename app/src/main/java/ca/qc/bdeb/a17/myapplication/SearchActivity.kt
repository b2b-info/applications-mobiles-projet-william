package ca.qc.bdeb.a17.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import ca.qc.bdeb.a17.myapplication.API.BookAPI
import ca.qc.bdeb.a17.myapplication.API.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity() {
    lateinit var bookApi: BookAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recherche_book)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Recherche internet"
        setSupportActionBar(toolbar)

        bookApi = RetrofitHelper.getInstance().create(BookAPI::class.java)
        findViewById<Button>(R.id.Sbutton).setOnClickListener(View.OnClickListener {
            lifecycleScope.launch {
                val wtv =
                    bookApi.getSearch((findViewById<EditText>(R.id.APIsearchText)).text.toString())
                        .body()
                if (wtv?.docs?.get(0) != null) {
                    findViewById<TextView>(R.id.resultAPI).setText(wtv.docs.get(0).title)
                }
            }

        })


    }

    public suspend fun searchAPI() {

        val wtv = bookApi.getSearch("Lord of the ring").body()
        if (wtv?.docs?.get(0) != null) {
            findViewById<TextView>(R.id.resultAPI).setText(wtv.docs.get(0).title)
        }

    }
}