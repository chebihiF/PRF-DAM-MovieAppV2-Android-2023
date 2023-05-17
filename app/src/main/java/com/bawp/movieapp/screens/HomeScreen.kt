package com.bawp.movieapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bawp.movieapp.MovieRow
import com.bawp.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(navController: NavController, moviesList: List<String> = listOf(
    "Avatar", "300", "Harry Potter", "Be Happy", "Cross the line" ,"Happiness ...", "Life"
)){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = moviesList){
                MovieRow(movie = it){ movie ->
                    navController.navigate(route=MovieScreens.DetailsScreen.name)
                }
            }
        }
    }
}