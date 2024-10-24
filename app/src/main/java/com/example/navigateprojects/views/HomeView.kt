package com.example.navigateprojects.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navigateprojects.components.ActionButton
import com.example.navigateprojects.components.MainButton
import com.example.navigateprojects.components.Space
import com.example.navigateprojects.components.SpaceH
import com.example.navigateprojects.components.TitleBar
import com.example.navigateprojects.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color( 0xFF900D47)
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()

        MainButton(name = "App Descuentos", backColor = Color(0xFFBC27D4  ) , color = Color.White) {
            navController.navigate("DescuentosView")
        }

        SpaceH()

        MainButton(name = "App Años Perrunos", backColor = Color( 0xFF53128A ), color = Color.White) {
            navController.navigate("DogAgeView")
        }

        SpaceH()

        MainButton(name = "App Loteria", backColor = Color( 0xFF1037BB ) , color = Color.White) {
            navController.navigate("LoteriaView")
        }
    }
}