package ca.qc.bdeb.a17.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Rendre la toolbar actif
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    //Rendre le menu actif
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //Définir les action de chaque item du menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.item1 ->
            {
                Toast.makeText(this, "Item 1 sélectionné", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 ->
            {
                Toast.makeText(this, "Item 2 sélectionné", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item3 ->
            {
                Toast.makeText(this, "Item 3 sélectionné", Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

}