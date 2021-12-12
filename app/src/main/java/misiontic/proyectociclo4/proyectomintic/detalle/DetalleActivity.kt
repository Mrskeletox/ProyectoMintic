package misiontic.proyectociclo4.proyectomintic.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import misiontic.proyectociclo4.proyectomintic.databinding.ActivityDetalleBinding
import misiontic.proyectociclo4.proyectomintic.model.LugaresItem



class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val lugar: LugaresItem = intent.extras?.getSerializable("lugar") as LugaresItem
        with(detalleBinding){
            nombreTextView.text = lugar.nombre
            descripcionTextView.text = lugar.descripcion
            calificacionTextView.text = lugar.calificacion
            Picasso.get().load(lugar.urlPicture).into(pictureImageView)
        }





    }
}