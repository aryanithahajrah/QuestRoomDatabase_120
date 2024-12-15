package com.example.prak7.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.prak7.data.dao.MahasiswaDao
import com.example.prak7.data.entity.Mahasiswa
import java.time.Instant

// Mendefiniskan database dengan table Mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class  KrsDatabase : RoomDatabase() {

    // Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun  MahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // Memastikan bahwa nilai variabel Instance selalu sama di semua thread
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, // Class database
                    "KrsDatabase" // Nama database
                )
                    .build().also { Instance = it }
            }
        }
    }
}
