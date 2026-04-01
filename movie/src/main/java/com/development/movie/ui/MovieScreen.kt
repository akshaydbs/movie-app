package com.development.movie.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.development.coredesign.theme.AppTypography
import com.development.coredesign.theme.appSpacing

@Composable
fun MovieScreen(){

    Scaffold(Modifier
        .fillMaxSize(),
        topBar = {
            TopAppBar()
        }) {innerPadding->

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
@Preview
fun MovieItemRow(){
    Row(Modifier.fillMaxWidth().height(56.dp),) {
        AsyncImage(
            model = "",
            contentDescription = ""
        )
        Spacer(Modifier.width(appSpacing().lg))
        Column() {
            Row() {

            }
        }

    }
}