package misiontic.proyectociclo4.turismo.model


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
    val urlPicture: String,
    @SerializedName("latitud")
    val latitud : Double,
    @SerializedName("longitud")
    val longitud: Double,
    @SerializedName("zoom")
    val zoom : Float
) : Serializable