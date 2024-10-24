package com.example.navigateprojects.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.navigateprojects.components.MainIconButton
import com.example.navigateprojects.viewModels.LoteriaViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoteriaView (navController: NavController) {
    Scaffold ( topBar = {
        CenterAlignedTopAppBar(
            title = { Text (text = "AppLoteria", color = Color.White) },
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
        LoteriaViews(navController = navController, viewModel = viewModel())
    }
}

@Composable
fun LoteriaViews ( navController: NavController, viewModel: LoteriaViewModel) {
    val lotoNumbers = viewModel.lotoNumbers.value

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if ( lotoNumbers.isEmpty() ) {
            Text (
                text = "Lotería",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        } else {
            LotteryNumbers ( lotoNumbers )
        }

        Button (
            onClick = { viewModel.generateLotoNumbers() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color( 0xFF4F1788 )
            )
        ) {
            Text (
                text = "Generar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun LotteryNumbers ( lotoNumbers: List<Int> ) {
    LazyRow (
        contentPadding = PaddingValues (
            horizontal = 16.dp,
            vertical = 8.dp
        )
    ) {
        items ( lotoNumbers ) { number ->
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color(0xFF68BCFE), CircleShape)
            ) {
                Text (
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}