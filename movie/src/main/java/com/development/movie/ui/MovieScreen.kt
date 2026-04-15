package com.development.movie.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.InsertChartOutlined
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import com.development.coredesign.theme.AppTypography
import com.development.coredesign.theme.appSpacing
import com.development.movie.domain.Movie

@Composable
fun MovieScreen(
    movies: List<Movie>
) {

    Scaffold(
        Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar()
        }) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(movies) { movie ->
                MovieItemRow(movie = movie)
            }

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(){
    CenterAlignedTopAppBar(
        title = { Text("Movie", style = AppTypography().titleLarge
        ) },
        navigationIcon = {
            IconButton(
                onClick = {}
            ) { Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back") }
        },
        actions = {
            IconButton(
                onClick = {}
            ) { Icon(imageVector = Icons.Default.Info, contentDescription = "")
            }
        }


    )
}

@Composable
fun MovieItemRow(movie: Movie){
    Row(Modifier
        .fillMaxWidth()
        .height(160.dp)
        .padding(horizontal = 32.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            contentDescription = "",
            model = movie.posterPath,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(120.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(Modifier.width(appSpacing().lg))
        Column( modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column() {
                Spacer(Modifier.height(appSpacing().sm))
                Text(
                    text = movie.title, style = AppTypography().bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
            Column (modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround) {
                MovieIconText(Icons.Default.InsertChartOutlined, "Action")
                MovieIconText(Icons.Default.Info, "2021")
                MovieIconText(Icons.Default.LockClock,movie.releaseDate?:"")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun MovieIconTextPreview() {
    MovieItemRow(
        Movie(
            id = 123, rating = 7.00,
            title ="Spider",
            overview = "Hello",
            posterPath = "xyz",
            releaseDate = "2025",
        )
    )
}


@Composable
fun MovieIconText(icon : ImageVector, title : String){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = "")
        Spacer(modifier = Modifier.width(appSpacing().sm))
        Text(text = title, style = AppTypography().labelSmall)
    }
}