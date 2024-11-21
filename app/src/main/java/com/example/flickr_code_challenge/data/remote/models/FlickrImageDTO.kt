package com.example.flickr_code_challenge.data.remote.models

data class FlickrImageDTO(
    val author: String,
    val author_id: String,
    val date_taken: String,
    val description: String,
    val link: String,
    val published: String,
    val media: FlickrMediaDTO,
    val tags: String,
    val title: String
)