package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackcomposeTheme
import com.example.jetpackcompose.ui.theme.Purple40

@Composable
fun gymsscreen(){
LazyColumn( ){
    items(listofgyms){
        gymitem(it)
    }
}


}

@Composable
fun gymitem(gym: Gym) {
    Card (elevation = 4.dp, modifier = Modifier.padding(5.dp)){
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)){
            gymimage(Icons.Filled.AccountBox, modifier = Modifier.weight(15f))
            gymdetails(gym,modifier = Modifier.weight(85f) )
        }

    }
}
@Composable
fun gymimage(vector: ImageVector,modifier: Modifier) {
    Image(imageVector =vector , contentDescription ="this is image", modifier = modifier, colorFilter = ColorFilter.tint(
        Color.DarkGray) )
}

@Composable
fun gymdetails(gym: Gym,modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text =gym.name , style =MaterialTheme.typography.h5, color = Purple40)
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = gym.place, style = MaterialTheme.typography.body2)

        }


    }
}
@Preview(showBackground = true)
@Composable
fun previewscreen(){
    JetpackcomposeTheme{
        gymsscreen()
    }
}


