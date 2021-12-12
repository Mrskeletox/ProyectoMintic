package misiontic.proyectociclo4.proyectomintic.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import misiontic.proyectociclo4.proyectomintic.R
import misiontic.proyectociclo4.proyectomintic.detalle.DetalleActivity
import misiontic.proyectociclo4.proyectomintic.model.Lugares
import misiontic.proyectociclo4.proyectomintic.model.LugaresItem


class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listLugares: ArrayList<LugaresItem>
    private lateinit var lugaresAdapter: LugaresAdapter
    private lateinit var lugaresRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresRecyclerView = findViewById(R.id.recycler_view)

        //listLugares = createMockLugares()
        listLugares = loadMockLugaresFromJson()

        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = {onLugarClicked(it)})

        //lugaresRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onLugarClicked(lugar: LugaresItem) {
        Log.d("nombre", lugar.nombre)
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("lugar", lugar)
        startActivity(intent)

    }

    private fun loadMockLugaresFromJson(): ArrayList<LugaresItem> {

        var lugaresString: String = applicationContext.assets.open("lugares.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugaresString, Lugares::class.java)
        return data
    }
}


