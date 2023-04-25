package com.example.mockprobleminha.produtos

class ProductRepositoryImpl: IProductRepository {
    override fun getProducts(): List<ProductModel> {
        return listOf(
            ProductModel("001", "Camiseta Branca"),
            ProductModel("002", "Calça Jeans"),
            ProductModel("003", "Tênis Preto"),
            ProductModel("004", "Vestido Estampado"),
            ProductModel("005", "Bermuda Jeans"),
            ProductModel("006", "Blusa de Lã"),
            ProductModel("007", "Saia Plissada"),
            ProductModel("008", "Jaqueta de Couro"),
            ProductModel("009", "Moletom Cinza"),
            ProductModel("010", "Shorts Jeans"),
            ProductModel("011", "Camisa Social"),
            ProductModel("012", "Sapatilha Preta"),
            ProductModel("013", "Suéter Azul"),
            ProductModel("014", "Macacão Floral"),
            ProductModel("015", "Sandália de Salto")
        )
    }
}