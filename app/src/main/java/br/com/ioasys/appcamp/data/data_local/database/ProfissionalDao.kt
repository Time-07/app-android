package br.com.ioasys.appcamp.data.data_local.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.ioasys.appcamp.data_local.model.ProfissionalDataLocal

interface ProfissionalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProfissionals(profissionalList: List<ProfissionalDataLocal>)

    @Query("SELECT * FROM Profissionals")
    fun getProfissionals(): List<ProfissionalDataLocal>

}