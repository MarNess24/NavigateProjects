package com.example.navigateprojects.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigateprojects.viewModels.LoteriaViewModel
import com.example.navigateprojects.views.DescuentosView
import com.example.navigateprojects.views.DogAgeView
import com.example.navigateprojects.views.HomeView
import com.example.navigateprojects.views.LoteriaView

@Composable
fun NavManager(viewModel: LoteriaViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable( "Home" ) {
            HomeView( navController )
        }

        composable( "DescuentosView" ) {
            DescuentosView( navController )
        }

        composable( "DogAgeView" ) {
            DogAgeView( navController )
        }

        composable( "LoteriaView" ) {
            LoteriaView(navController = navController)
        }
    }
}