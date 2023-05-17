package com.bawp.movieapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movieData: String?){
    Text(text = movieData.toString())
}