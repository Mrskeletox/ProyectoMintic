package misiontic.proyectociclo4.turismo.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import misiontic.proyectociclo4.turismo.databinding.FragmentDetailBinding
import misiontic.proyectociclo4.turismo.main.MainActivity


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugares = args.lugar
        with(detailBinding){
            nombreTextView.text = lugares.nombre
            descripcionTextView.text = lugares.descripcion
            calificacionTextView.text = lugares.calificacion
            com.squareup.picasso.Picasso.get().load(lugares .urlPicture).into(pictureImageView)
        }

    }



}