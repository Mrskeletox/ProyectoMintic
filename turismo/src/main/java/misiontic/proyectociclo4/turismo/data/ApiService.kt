package misiontic.proyectociclo4.turismo.data

import misiontic.proyectociclo4.turismo.model.Lugares
import retrofit2.http.GET

interface ApiService {
    @GET("/Mrskeletox/ProyectoMintic/lugares")
    suspend fun getLugares() : Lugares
}