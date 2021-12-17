package misiontic.proyectociclo4.turismo.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import misiontic.proyectociclo4.turismo.data.LugaresRepository
import misiontic.proyectociclo4.turismo.model.Lugares
import misiontic.proyectociclo4.turismo.model.LugaresItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var lugaresLoad : MutableLiveData<ArrayList<LugaresItem>> = MutableLiveData()
    val onLugaresLoaded : LiveData<ArrayList<LugaresItem>> = lugaresLoad

    private val repository = LugaresRepository()

    fun getLugaresFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            lugaresLoad.postValue(repository.getLugares())
        }
    }

  fun loadMockLugaresFromJson(lugaresString: InputStream?) {
      val lugaresString = lugaresString?.bufferedReader().use { it!!.readText() }
      val gson = Gson()
      lugaresLoad.value = gson.fromJson(lugaresString, Lugares::class.java)
  }
}
