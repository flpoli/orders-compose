package com.example.mockprobleminha.produtos


data class SelectableProductUiState(
    val product: ProductModel,
    val isSelected: Boolean = false
)

data class ProductSelectionState(
    val selectableProduct: List<SelectableProductUiState> = emptyList()
)