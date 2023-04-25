package com.example.mockprobleminha.produtos

data class ProductUiModel (
    val allProducts: List<ProductModel> = emptyList(),
    val selectedProducts: List<SelectedProduct> = emptyList(),
    )

data class SelectedProduct(
    val isSelected: Boolean = false,
    val product: ProductModel = ProductModel()
)