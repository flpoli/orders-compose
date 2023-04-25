package com.example.mockprobleminha.produtos

interface IProductRepository {
    fun getProducts(): List<ProductModel>
}