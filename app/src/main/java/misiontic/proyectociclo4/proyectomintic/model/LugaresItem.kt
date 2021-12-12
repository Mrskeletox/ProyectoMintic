package misiontic.proyectociclo4.proyectomintic.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugaresItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable