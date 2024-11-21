package com.example.flickr_code_challenge.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.flickr_code_challenge.ui.FlickrViewModel
import com.example.flickr_code_challenge.ui.navigation.Route
import com.example.flickr_code_challenge.ui.theme.Flickr_code_challengeTheme
import com.example.flickr_code_challenge.utils.IOResult
import com.example.flickr_code_challenge.utils.ResultType

@Composable
fun MainScreen(controller: NavController?, viewModel: FlickrViewModel) {

    Column{
        FlickrSearch(viewModel)


        when(viewModel.images.collectAsState().value.type){
            ResultType.FAILED ->{
                Text("AN ERROR HAS HAPPENED")

            }
            ResultType.INPROGRESS -> {
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(0.8f),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
            ResultType.SUCCESS -> {
                if(!viewModel.images.collectAsState().value.body.isNullOrEmpty()){
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(minSize = 120.dp)
                    ) {
                        items(viewModel.images.value.body!!){ image ->
                            Picture(image.media.m){
                                viewModel.changeSelected(image)
                                controller?.navigate(Route.Details.id)
                            }
                            Log.d("DEBUGGING IMAGE", image.link)
                        }

                    }
                }else{
                    Text("NO DATA")
                }
            }
        }


    }
}

@Composable
fun FlickrSearch(viewModel: FlickrViewModel){
    TextField(
        value = viewModel.textInput.collectAsState().value,
        onValueChange = { viewModel.changeTextInput(it) },
        modifier = Modifier
            .fillMaxWidth()
            .testTag("SearchBar")
    )
}

@Composable
fun Picture(url:String, onClick:() -> Unit){


        AsyncImage(
            model = url,
            contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
                .clickable {
                    onClick()
                }

        )

}

@Preview(showBackground = true)
@Composable
fun mainScreenPreview(){
    Flickr_code_challengeTheme {
        MainScreen(null, FlickrViewModel())
    }
}