package com.example.flickr_code_challenge.data.remote.models

data class FlickrResponseDTO(
    val description: String,
    val generator: String,
    val items: List<FlickrImageDTO>,
    val link: String,
    val modified: String,
    val title: String
)