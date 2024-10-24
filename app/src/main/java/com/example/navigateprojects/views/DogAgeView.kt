package com.example.navigateprojects.views

import android.annotation.SuppressLint
import android.view.ViewManager
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigateprojects.R
import com.example.navigateprojects.components.MainIconButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogAgeView(navController: NavController)
{
    Scaffold ( topBar = {
        CenterAlignedTopAppBar(
            title = { Text (text = "Dog Age Calculator", color = Color.White) },
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
        ContentDogAgeView(modifier = Modifier)
    }
}

@Composable
fun ContentDogAgeView(modifier: Modifier = Modifier) {
    val imagen = painterResource ( id = R.drawable.perrito )

    Column (
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Variables
        var ageN by remember { mutableStateOf ( "" ) }
        var ageD by remember { mutableStateOf ( "" ) }

        // Foto
        Image (
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(top = 50.dp)
        )

        Spacer( modifier = Modifier.height(25.dp) )

        // Título
        Text(
            text = "Dog Age Calculator",
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            color = Color( 0xFF473211 ),
            textAlign = TextAlign.Center
        )

        //Spacer( modifier = Modifier.height( 20.dp ) )
        val context = LocalContext.current

        // Edad humana
        OutlinedTextField (
            value = ageN,   // valor en caja de texto
            label = { Text ( text = "My human age", fontSize = 25.sp ) },
            keyboardOptions = KeyboardOptions ( keyboardType = KeyboardType.Number ),
            onValueChange = {
                val input = it.trim()
                if ( input.toIntOrNull() == null ) {
                    Toast.makeText( context, "Ingrese una edad válida!", Toast.LENGTH_LONG ).show()
                    ageN = ""
                } else {
                    ageN = it
                }
            },
            leadingIcon = { Icon ( imageVector = Icons.Default.Face, contentDescription = "icon" ) },
            placeholder = { Text( text = "Age" ) },
            textStyle = TextStyle( fontSize = 25.sp ),
            modifier = modifier
                .padding( 15.dp )
        )

        // Botón Calcular
        Button(
            onClick = {
                var res = 0
                res = ageN.toInt() * 7
                ageD = res.toString()
            },
            colors = ButtonDefaults.buttonColors( containerColor = Color( 0xFF473211 ) ),
            modifier = modifier
                .padding( 15.dp )
        ) {
            Text (
                text = "Calculate",
                fontSize = 25.sp,
            )
        }

        // Edad perruna
        OutlinedTextField (
            value = ageD,
            readOnly = true,
            label = { Text ( text = "My dog age", fontSize = 25.sp ) },
            onValueChange = { ageD = it },
            leadingIcon = { Icon ( imageVector = Icons.Default.Favorite, contentDescription = "icon" ) },
            placeholder = { Text( text = "Dog Age" ) },
            textStyle = TextStyle( fontSize = 25.sp ),
            modifier = modifier
                .padding( 15.dp )
        )

        // Botón Borrar
        Button(
            onClick = {
                ageN = ""
                ageD = ""
            },
            colors = ButtonDefaults.buttonColors( containerColor = Color( 0xFF473211 ) ),
            modifier = modifier
                .padding( 15.dp )
        ) {
            Text (
                text = "Borrar",
                fontSize = 25.sp
            )
        }
    }
}