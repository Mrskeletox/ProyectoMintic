package misiontic.proyectociclo4.proyectomintic


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter:RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val titles = arrayOf("El planetario" ,"El pueblito paisa" ,"Jardin botanico" ,"Plaza Botero")
    val details= arrayOf("El Planetario de Medellín Jesús Emilio Ramírez González ofrece a sus visitantes un escenario a la altura de los más modernos del mundo, con un domo digital para experiencias de inmersión de alta calidad. " ,
        "En la parte más alta del Cerro Nutibara, encontrarás el Pueblito Paisa, un lugar donde la tradición, idiosincrasia y color del ciudadano paisa se hace homenaje en una representación típica de los pueblos tradicionales antioqueños" ,
        "El Jardín cuenta con la condición de ser centro de cultura y educación ambiental y botánica, de enorme riqueza florística, y alberga más de 1000 especies vivas" ,
        "un museo al aire libre, que muestra su perfección en 23 esculturas de bronce, rodeadas de palmeras que hacen perfecto juego con el azul del cielo y las ropas multicolores de los turistas")
    val images = intArrayOf(R.drawable.planetario,
        R.drawable.pueblito ,
        R.drawable.jardin_botanico ,
        R.drawable.botero)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = titles[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_titulo)
            itemDetail = itemView.findViewById(R.id.item_descripcion)

        }
    }

}