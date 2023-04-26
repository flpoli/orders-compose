package com.example.mockprobleminha.produtos

data class ProductUiModel (
    val allProducts: List<ProductModel> = emptyList(),
    val selectedProducts: List<SelectableProduct>? = null,
    )

data class SelectableProduct(
    val isSelected: Boolean = false,
    val product: ProductModel = ProductModel()
)