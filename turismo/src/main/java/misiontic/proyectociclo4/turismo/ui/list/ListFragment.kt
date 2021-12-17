package misiontic.proyectociclo4.turismo.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import misiontic.proyectociclo4.turismo.databinding.FragmentListBinding
import misiontic.proyectociclo4.turismo.ui.main.MainActivity
import misiontic.proyectociclo4.turismo.model.LugaresItem


class ListFragment : Fragment() {

    private var listLugares: ArrayList<LugaresItem> = arrayListOf()
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var lugaresAdapter: LugaresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()

        //listViewModel.loadMockLugaresFromJson(context?.assets?.open("lugares.json"))

        listViewModel.getLugaresFromServer()

        listViewModel.onLugaresLoaded.observe(viewLifecycleOwner, { result ->
            onLugarLoadedSubscribe(result)
        })
        lugaresAdapter = LugaresAdapter(listLugares, onItemClicked ={onLugarClicked(it) }  )

        listBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
    }


    private fun onLugarLoadedSubscribe(result: ArrayList<LugaresItem>?) {
        result?.let{listLugares ->
            lugaresAdapter.appendItems(listLugares)
        }
    }

    private fun onLugarClicked(lugar: LugaresItem){

        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(lugar = lugar))
    }

}