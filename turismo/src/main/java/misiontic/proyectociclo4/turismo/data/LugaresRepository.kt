package misiontic.proyectociclo4.turismo.data

class LugaresRepository {

    suspend fun getLugares() = ApiFactory.retrofit.getLugares()
}