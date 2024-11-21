package com.example.flickr_code_challenge.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickr_code_challenge.data.remote.api.ApiServices
import com.example.flickr_code_challenge.data.remote.models.FlickrImageDTO
import com.example.flickr_code_challenge.utils.IOResult
import com.example.flickr_code_challenge.utils.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FlickrViewModel: ViewModel() {


    private val _textInput: MutableStateFlow<String> = MutableStateFlow("")
    val textInput = _textInput.asStateFlow()



    private val _images: MutableStateFlow<IOResult<List<FlickrImageDTO>>> = MutableStateFlow(IOResult(ResultType.SUCCESS, null))
    val images = _images.asStateFlow()

    private val _selected: MutableStateFlow<FlickrImageDTO?> = MutableStateFlow(null)
    val selected = _selected.asStateFlow()


    init {
        callApi()
    }



    private fun callApi(){
        viewModelScope.launch(Dispatchers.IO) {
            textInput.collect{
                if(textInput.value != ""){
                    _images.value =  IOResult(ResultType.INPROGRESS, null )

                    val response = try{
                        ApiServices.api.getImages(textInput.value)
                    }catch (e:Exception){
                        null
                    }

                    if (response != null && response.isSuccessful){
                        _images.value =  IOResult(ResultType.SUCCESS, response.body()?.items ?: emptyList())
                    }else{
                        _images.value =  IOResult(ResultType.FAILED, null )

                    }

                }

            }
        }

    }

    fun changeTextInput(new:String){
        _textInput.value = new
    }

    fun changeSelected(new:FlickrImageDTO){
        _selected.value = new
    }
}