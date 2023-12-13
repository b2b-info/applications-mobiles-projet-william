package ca.qc.bdeb.a17.myapplication.DAO.Database
import androidx.room.Database
import androidx.room.RoomDatabase
import ca.qc.bdeb.a17.myapplication.DAO.Entity.Book
import ca.qc.bdeb.a17.myapplication.DAO.Interface.BookDao

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}