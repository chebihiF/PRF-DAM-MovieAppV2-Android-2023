package com.bawp.movieapp.screens

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bawp.movieapp.model.Movie
import com.bawp.movieapp.model.getMovies
import com.bawp.movieapp.widgets.MovieRow


@Composable
fun DetailsScreen(navController: NavController, movieId: String?){

    val movieDetails = getMovies().filter { movie -> movie.id == movieId }[0]

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }

        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                MovieRow(movie = movieDetails)
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalScrollableImageView(movieDetails)
            }
        }
    }


}

@Composable
private fun HorizontalScrollableImageView(movieDetails: Movie) {
    LazyColumn {
        items(movieDetails.images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}