package br.com.ioasys.appcamp.data_local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.ioasys.appcamp.data_local.model.ProfessionalDataLocal

@Dao
interface ProfessionalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProfessionals(professionalList: List<ProfessionalDataLocal>)

    @Query("SELECT * FROM Professionals")
    fun getProfessionals(): List<ProfessionalDataLocal>
}