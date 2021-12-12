package misiontic.proyectociclo4.turismo.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import misiontic.proyectociclo4.turismo.databinding.FragmentListBinding
import misiontic.proyectociclo4.turismo.main.MainActivity
import misiontic.proyectociclo4.turismo.model.Lugares
import misiontic.proyectociclo4.turismo.model.LugaresItem


class ListFragment : Fragment() {

    private lateinit var listLugares: ArrayList<LugaresItem>
    private lateinit var listBinding: FragmentListBinding
    private lateinit var lugaresAdapter: LugaresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listLugares = loadMockLugaresFromJson()
        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked = {onLugarClicked(it)})

        listBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }
    private fun onLugarClicked(lugar: LugaresItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))
    }
    private fun loadMockLugaresFromJson(): ArrayList<LugaresItem> {

        var lugaresString: String = context?.assets?.open("lugares.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(lugaresString, Lugares::class.java)
        return data
    }


}