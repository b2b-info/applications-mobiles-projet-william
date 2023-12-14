package ca.qc.bdeb.a17.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CommanditeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commandite)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Commandite"
        setSupportActionBar(toolbar)
    }
}