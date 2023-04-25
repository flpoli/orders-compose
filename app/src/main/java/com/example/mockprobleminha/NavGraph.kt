package com.example.mockprobleminha

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mockprobleminha.clientes.ClientModel
import com.example.mockprobleminha.clientes.ClientScreen
import com.example.mockprobleminha.pedido.OrderScreen
import com.example.mockprobleminha.produtos.ProductScreen

@Composable
fun NavGraph(nav: NavHostController) {

    NavHost(
        navController = nav,
        startDestination = "order"
    ) {

        composable("order") {

            val selectedClient = nav.currentBackStackEntry
                ?.savedStateHandle
                ?.getStateFlow<ClientModel?>("nav_key_client", null)
                ?.collectAsState()


            OrderScreen(
                selectedClient = selectedClient?.value,
                onNavToClientList = {
                    nav.navigate("client")
                },
                onNavToProductList = {
                    nav.navigate("product")
                }
            )
        }
        composable("client") {
            ClientScreen(
                onAddClick = {
                    nav.previousBackStackEntry?.savedStateHandle?.set(
                        key = "nav_key_client",
                        value = "Voltei da 2",
                    )
                    nav.navigateUp()
                }
            )
        }
        composable("product") {
            ProductScreen(
                onAddClick = {
                    nav.previousBackStackEntry?.savedStateHandle?.set(
                        key = "nav_key_product",
                        value = "Voltei da 3",
                    )
                    nav.navigateUp()
                }
            )
        }
    }
}