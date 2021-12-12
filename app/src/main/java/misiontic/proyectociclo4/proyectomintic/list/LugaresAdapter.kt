package misiontic.proyectociclo4.proyectomintic.list


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import misiontic.proyectociclo4.proyectomintic.model.LugaresItem
import misiontic.proyectociclo4.proyectomintic.R

class LugaresAdapter(
    private val lugaresList: ArrayList<LugaresItem>,
    private val onItemClicked : (LugaresItem) -> Unit
    ):RecyclerView.Adapter<LugaresAdapter.LugaresViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugares_item,parent, false)
        return LugaresViewHolder(view)


    }

    override fun onBindViewHolder(holder: LugaresViewHolder, position: Int) {

        val lugares =   lugaresList[position]
        holder.itemView.setOnClickListener {onItemClicked(lugaresList[position])}
        holder.bind(lugares)
    }

    override fun getItemCount(): Int = lugaresList.size

    class LugaresViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var tituloTextView: TextView = itemView.findViewById(R.id.item_titulo)
        private var descripcionTextView : TextView = itemView.findViewById(R.id.item_descripcion)
        private var calificacionTextView : TextView = itemView.findViewById(R.id.item_calificacion)
        private var pictureImageView : ImageView = itemView.findViewById(R.id.item_image_vista)


        fun bind(lugares: LugaresItem){
            Log.d("nombre",lugares.nombre)
            tituloTextView.text = lugares.nombre
            descripcionTextView.text = lugares.descripcion
            calificacionTextView.text = lugares.calificacion
            Picasso.get().load(lugares.urlPicture).into(pictureImageView);

        }

    }
}