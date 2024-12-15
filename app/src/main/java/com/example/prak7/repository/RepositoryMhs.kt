package com.example.prak7.repository

import com.example.prak7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
    suspend fun deleteMhs(mahasiswa: Mahasiswa)
    suspend fun updateMhs(mahasiswa: Mahasiswa)

    fun getAllMhs() : Flow<List<Mahasiswa>>
    fun getMhs(nim: String) : Flow<Mahasiswa>
}