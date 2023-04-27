package com.example.mockprobleminha

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mockprobleminha.clientes.ClientModel
import com.example.mockprobleminha.clientes.ClientScreen
import com.example.mockprobleminha.pedido.OrderScreen
import com.example.mockprobleminha.produtos.ProductModel
import com.example.mockprobleminha.produtos.ProductScreen
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun AntesOrder(
    onNavToOrder: () -> Unit,
) {
    Column {
        Text(text = "Antes order")
        Button(onClick = onNavToOrder) {
            Text(text = "Vai")
        }
    }
}

@Composable
fun DepoisOrder(
    client: ClientModel
) {
    Column {
        Text(text = "Olá ${client.nome}")
    }
}

@Composable
fun NavGraph(nav: NavHostController) {

    NavHost(
        navController = nav,
        startDestination = "antes_order"
    ) {
        composable("antes_order") {
            AntesOrder(
                onNavToOrder = { nav.navigate("order") }
            )
        }
        composable("order") {
            val productList = nav.getParam<List<ProductModel>>("nav_key_product")

            val clientType = object : TypeToken<ClientModel>() {}.type
            val jsonClient = nav.getBackArg<String>("nav_key_client")?.collectAsState()
            val client = Gson().fromJson<ClientModel>(jsonClient?.value, clientType)

            OrderScreen(
                selectedClient = client,
                onNavToClientList = {
                    nav.navigate("client")
                },
                onNavToProductList = {
                    nav.navigate("product")
                },
                onNavToDepois = { client ->
                    val encodedClient = getEncodedJsonParam(client)
                    nav.navigate("depois_order".plus("?client_arg=$encodedClient"))
                },
                productList = productList,
                client = client,
            )
        }
        composable("client") {
            ClientScreen(
                onAddClick = { client ->
                    nav.previousBackStackEntry?.savedStateHandle?.set(
                        key = "nav_key_client",
                        value = Gson().toJson(client),
                    )
                    nav.navigateUp()
                }
            )
        }
        composable("product") {
            ProductScreen(
                onAddClick = { productList ->
                    nav.previousBackStackEntry?.savedStateHandle?.set(
                        key = "nav_key_product",
                        value = Gson().toJson(productList),
                    )
                    nav.navigateUp()
                }
            )
        }
        composable(
            route = "depois_order?client_arg={client_arg}",
            arguments = listOf(
                navArgument("client_arg") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            val jsonClient = entry.arguments?.getString("client_arg")
            val clientType = object : TypeToken<ClientModel>() {}.type
            val client = Gson().fromJson<ClientModel>(jsonClient, clientType)

            DepoisOrder(client)
        }
    }
}

@Composable
inline fun <reified T> NavHostController.getParam(
    paramName: String,
): T? {
    val type = object : TypeToken<T>() {}.type
    val json = getBackArg<String>(paramName)?.collectAsState()
    return Gson().fromJson<T>(json?.value, type)
}

fun <T> NavHostController.getBackArg(
    argKey: String
) = currentBackStackEntry
    ?.savedStateHandle
    ?.getStateFlow<T?>(argKey, null)

fun <T> getEncodedJsonParam(
    rawParam: T
): String {
    val jsonParam = Gson().toJson(rawParam)
    return Uri.encode(jsonParam)
}