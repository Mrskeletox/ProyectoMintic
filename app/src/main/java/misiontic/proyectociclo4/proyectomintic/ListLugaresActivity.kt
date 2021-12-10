package misiontic.proyectociclo4.proyectomintic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import drawable.LugaresAdapter


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

        lugaresAdapter = LugaresAdapter(listLugares)

        //lugaresRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }

    }

    private fun loadMockLugaresFromJson(): ArrayList<LugaresItem> {

        var lugaresString: String =
            applicationContext.assets.open("lugares.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugaresString, Lugares::class.java)
        return data
    }
}


