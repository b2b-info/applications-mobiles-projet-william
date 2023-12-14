package ca.qc.bdeb.a17.myapplication.DAO.Interface

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ca.qc.bdeb.a17.myapplication.DAO.Entity.Book

@Dao
interface BookDao {
    @Insert
    fun insertBook(book: Book)

    @Query("SELECT * FROM livres")
    fun getAllBooks(): List<Book>

    @Query("DELETE FROM livres")
    suspend fun deleteAllBooks()
}