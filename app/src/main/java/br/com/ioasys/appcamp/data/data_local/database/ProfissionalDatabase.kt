package br.com.ioasys.appcamp.data.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.ioasys.appcamp.data_local.model.ProfissionalDataLocal


@Database(entities = [ProfissionalDataLocal::class], version = 1)
abstract class ProfissionalDatabase: RoomDatabase() {

    abstract fun profissionalDao(): ProfissionalDao
}