package br.com.ioasys.appcamp.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.ioasys.appcamp.data_local.model.ProfessionalDataLocal

@Database
(entities = [ProfessionalDataLocal::class], version = 1)
abstract class ProfessionalDatabase: RoomDatabase() {

    abstract fun professionalDao(): ProfessionalDao
}