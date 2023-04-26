package com.example.mockprobleminha.produtos

class ProductRepositoryImpl: IProductRepository {
    override fun getProducts(): List<ProductModel> {
        return listOf(
            ProductModel("001", "Camiseta Branca"),
            ProductModel("002", "Calça Jeans"),
            ProductModel("003", "Tênis Preto"),
            ProductModel("004", "Vestido Estampado"),
            ProductModel("005", "Bermuda Jeans"),
        )
    }
}