package com.example.jetpackcompose.gyms.presentaion.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.gyms.domain.Gym
import com.example.jetpackcompose.ui.theme.Purple40

@Composable
fun GymsDetailsScreen(){
    val vm: GymDetailsViewModel = viewModel()
    val state=vm.state.value
    Column (modifier = Modifier
        .padding(10.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Gymimage(Icons.Filled.LocationOn,Modifier.padding(15.dp))
        if (state != null) {
            Gymdetails(modifier = Modifier.padding(bottom = 32.dp, top = 32.dp), gym = state)

        }
    }

}
@Composable

fun Gymimage(vector: ImageVector,modifier: Modifier){
    Image(imageVector = vector, contentDescription ="location image" , modifier = modifier, alignment = Alignment.Center)


}
@Composable
fun Gymdetails(modifier: Modifier,gym: Gym){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = gym.name,modifier, color = Purple40, style = MaterialTheme.typography.h5)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium ) {
            Text(text = gym.place,modifier, style = MaterialTheme.typography.body2)

        }
    }



}
//@Preview(showBackground = true)
//@Composable
//fun previewscreen2() {
//    JetpackcomposeTheme {
//        GymsDetailsScreen()
//    }
//    }


