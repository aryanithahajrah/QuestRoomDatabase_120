package com.example.prak7.dependenciesinjection

import android.content.Context
import com.example.prak7.data.database.KrsDatabase
import com.example.prak7.repository.LocalRepositoryMhs
import com.example.prak7.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).MahasiswaDao())
    }
}