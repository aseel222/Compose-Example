package com.example.jetpackcompose.gyms.presentaion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.jetpackcompose.gyms.presentaion.details.GymsDetailsScreen
import com.example.jetpackcompose.gyms.presentaion.gymslist.GymViewModel
import com.example.jetpackcompose.gyms.presentaion.gymslist.Gymsscreen
import com.example.jetpackcompose.ui.theme.JetpackcomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposeTheme {
             GymsAroundApp()
            }
        }
    }
    @Composable
    private fun GymsAroundApp(){
       val navController= rememberNavController()

        NavHost(navController =navController , startDestination ="gyms"  ){
            composable(route="gyms"){
                val vm:GymViewModel= hiltViewModel()
                Gymsscreen(state =vm.state.value , onItemClick ={
                    navController.navigate("gyms/$it")
                } , onFavItemClick ={ id,oldvalue ->
                      vm.togglestate(id,oldvalue)
                } )

                }

            composable(route="gyms/{gym_id}", arguments = listOf(navArgument("gym_id"){
                type= NavType.IntType
            }), deepLinks = listOf(navDeepLink { uriPattern="www.gymsaround.com/details/{gym_id}" })
            ){
               // val gymid=it.arguments?.getInt("gym_id")
                GymsDetailsScreen()

            }
        }

    }
}




