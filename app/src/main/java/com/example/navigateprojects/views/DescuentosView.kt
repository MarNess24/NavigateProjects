package com.example.navigateprojects.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigateprojects.components.Alerta
import com.example.navigateprojects.components.BotonReutilizable
import com.example.navigateprojects.components.DosTarjetas
import com.example.navigateprojects.components.MainIconButton
import com.example.navigateprojects.components.SpaceH
import com.example.navigateprojects.components.TextFields

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescuentosView(navController: NavController)
{
    Scaffold ( topBar = {
        CenterAlignedTopAppBar(
            title = { Text (text = "AppDescuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.popBackStack()
                }
            }
        )
    }){
        ContentDescuentosView(it)
    }
}

@Composable
fun ContentDescuentosView(paddingValues: PaddingValues) {
    Column (
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var precioDescuento by remember { mutableStateOf("") }
        var precioTotal by remember { mutableStateOf("") }

        DosTarjetas(
            titulo1 = "Total",
            numero1 = precioTotal,
            titulo2 = "Descuento",
            numero2 = precioDescuento)

        TextFields(value = precio, onValueChange = {precio=it}, label = "Precio")
        SpaceH()
        TextFields(value = descuento, onValueChange = {descuento=it}, label = "Descuento")
        SpaceH(10.dp)
        BotonReutilizable("Calcular") {
            if (precio != "" && descuento!= "") {
                precioDescuento = (precio.toDouble() * ( descuento.toDouble() / 100)).toString()
                precioTotal = (precio.toDouble() - precioDescuento.toDouble()).toString()
            } else {
                /*Alerta(
                    title = "Sistema",
                    mensaje = "Hay un valor faltante",
                    mensajeConfirm = "Todo bien",
                    onConfirmClick = { *//*TODO*//* }
                ) {

                }*/
            }

        }
    }
}