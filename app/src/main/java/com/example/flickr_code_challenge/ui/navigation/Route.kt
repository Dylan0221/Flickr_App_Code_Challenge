package com.example.flickr_code_challenge.ui.navigation

sealed class Route(val id: String) {
    object Main: Route("main_Screen")
    object Details: Route("details_Screen")

}