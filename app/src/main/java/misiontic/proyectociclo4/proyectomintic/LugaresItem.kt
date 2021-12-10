package misiontic.proyectociclo4.proyectomintic


import com.google.gson.annotations.SerializedName

data class LugaresItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)