package ca.qc.bdeb.a17.myapplication.DAO.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livres")
data class Book (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val author: String,
    val pages: Int
)

