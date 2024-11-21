package com.example.flickr_code_challenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flickr_code_challenge.R
import com.example.flickr_code_challenge.ui.navigation.Route
import com.example.flickr_code_challenge.ui.screens.DetailsScreen
import com.example.flickr_code_challenge.ui.screens.MainScreen
import com.example.flickr_code_challenge.ui.theme.Flickr_code_challengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<FlickrViewModel>()

        setContent {
            Flickr_code_challengeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),

                    ) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()

                        NavHost(navController = navController, startDestination = Route.Main.id) {
                            composable(route = Route.Main.id) {

                                Column{
                                    TopBar("Details", navController,false )
                                    MainScreen(navController,viewModel)

                                }
                            }
                            composable(
                                route = Route.Details.id,
                            ) {
                                Column{
                                    TopBar("Details", navController,true )
                                    DetailsScreen(viewModel.selected.collectAsState().value!!)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar(title:String, controller: NavController,isDetails:Boolean){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Cyan),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        if (isDetails){
            Button(onClick = {
                controller.popBackStack()
            }) {
                Image(
                    painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = null
                )
            }
        }
        Text(
            text = title,
            color = Color.White
        )
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Flickr_code_challengeTheme {
    }
}