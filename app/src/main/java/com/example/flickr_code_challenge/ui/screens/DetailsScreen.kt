package com.example.flickr_code_challenge.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.flickr_code_challenge.data.remote.models.FlickrImageDTO
import com.example.flickr_code_challenge.utils.getFormattedAuthor
import com.example.flickr_code_challenge.utils.getFormattedDate

@Composable
fun DetailsScreen(image: FlickrImageDTO){

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            AsyncImage(image.media.m, null)

        }
        Text("TITLE: ${image.title}")
        Text("DESCRIPTION: ${image.description}")
        Text("AUTHOR: ${image.getFormattedAuthor()}" )
        Text("DATE: ${image.getFormattedDate()}")
    }
}