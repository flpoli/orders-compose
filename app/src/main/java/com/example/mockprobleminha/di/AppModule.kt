package com.example.mockprobleminha.di

import com.example.mockprobleminha.clientes.ClientRepositoryImpl
import com.example.mockprobleminha.clientes.IClientRepository
import com.example.mockprobleminha.produtos.IProductRepository
import com.example.mockprobleminha.produtos.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideClientRepository(): IClientRepository = ClientRepositoryImpl()

    @Provides
    @Singleton
    fun provideProductsRepository(): IProductRepository = ProductRepositoryImpl()
}