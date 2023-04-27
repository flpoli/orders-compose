package com.example.mockprobleminha.produtos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: IProductRepository
): ViewModel() {

    var state by mutableStateOf(ProductSelectionState())
        private set

    init {
        getProductList()
    }


    private fun getProductList() {
        viewModelScope.launch {

            val selectableProd = repository.getProducts().map {
                SelectableProductUiState(it)
            }
            state = state.copy(
                selectableProduct = selectableProd
            )
        }
    }

    fun onProductChecked(product: ProductModel){

        Log.d("Product", "$product")
        viewModelScope.launch {
            state = state.copy(
                selectableProduct = state.selectableProduct.map {
                    if(it.product == product){
                        it.copy(isSelected = !it.isSelected)
                    } else it
                }
            )
            Log.d("State", "$state")

        }
    }
}