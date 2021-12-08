package misiontic.proyectociclo4.proyectomintic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListLugaresActivity : AppCompatActivity() {

    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        recyclerView= findViewById<RecyclerView>(R.id.recycler_view)


        adapter = CustomAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
            setHasFixedSize(false)
        }
    }
}