package com.example.prak7.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.prak7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {
    //fungsi get all data
    @Query("select * from mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>

    // fungsi untuk mengambil data mahasiswa berdasarkan Nomor Induk Mahasiswa (NIM) yang diberikan
    @Query("select * from mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim: String) : Flow<Mahasiswa>

    // fungsi untuk menghapus data mahasiswa tertentu dari database
    @Delete
    suspend fun deleteMahasiswa (mahasiswa: Mahasiswa)

    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    @Update
    suspend fun updateMahasiswa (mahasiswa: Mahasiswa)
}