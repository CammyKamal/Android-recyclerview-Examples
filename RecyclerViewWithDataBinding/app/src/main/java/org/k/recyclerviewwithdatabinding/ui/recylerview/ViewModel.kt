package org.k.recyclerviewwithdatabinding.ui.recylerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.k.recyclerviewwithdatabinding.model.DataModel

class ViewModel : ViewModel() {
    private lateinit var dataModelList : List<DataModel>

    private val users: MutableLiveData<List<DataModel>> by lazy {
        MutableLiveData<List<DataModel>>().apply {
            value = loadUsers()
        }
    }

    fun getUsers(): LiveData<List<DataModel>> {
        return users
    }

    fun loadUsers(): List<DataModel> {
        dataModelList = listOf(
            DataModel("ABC" , "CSE"),
            DataModel("XYZ" , "ENG"),
            DataModel("Ram" , "ENG"),
            DataModel("Sham" , "CSE"),
            DataModel("Popes" , "CSE"),
            DataModel("Ollie" , "CSE"),
            DataModel("James" , "CSE")
        )
        return dataModelList
    }
}