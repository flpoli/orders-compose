package com.example.mockprobleminha.pedido

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mockprobleminha.clientes.ClientModel
import com.example.mockprobleminha.produtos.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {


    init{
        val saved: ClientModel? = savedStateHandle.get<ClientModel>("nav_key_client") // não funfa este
    }

    fun setData(client: ClientModel?, products: List<ProductModel>?){

        val saved = savedStateHandle.get<ClientModel>("nav_key_client") // why?
        Log.d("getData - savedState", "$saved")
        Log.d("getData - client", "$client")
        Log.d("getData - produto", "$products")
    }

}