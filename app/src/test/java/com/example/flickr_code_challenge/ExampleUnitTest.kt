package com.example.flickr_code_challenge

import com.example.flickr_code_challenge.data.remote.models.FlickrImageDTO
import com.example.flickr_code_challenge.data.remote.models.FlickrMediaDTO
import com.example.flickr_code_challenge.ui.FlickrViewModel
import com.example.flickr_code_challenge.utils.getFormattedAuthor
import com.example.flickr_code_challenge.utils.getFormattedDate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import java.lang.Thread.sleep

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val viewModel = FlickrViewModel()


    @Test
    fun `Test FlickrImageDTO getFormattedDate returns correct date`(){

        val i1 = FlickrImageDTO(
            "",
            "",
            "2024-11-21T05:26:34Z",
            "",
            "",
            "2024-11-21T05:26:34Z",
            FlickrMediaDTO(""),
            "",
            ""
        )

        assert(i1.getFormattedDate() == "21 NOVEMBER 2024")

    }


    @Test
    fun `Test FlickrImageDTO getFormattedAuthor returns correct name`(){

        val i1 = FlickrImageDTO(
            "(DAYLAN SANTIAGO)",
            "",
            "2024-11-21T05:26:34Z",
            "",
            "",
            "2024-11-21T05:26:34Z",
            FlickrMediaDTO(""),
            "",
            ""
        )
        val i2 = FlickrImageDTO(
            "IRON MAN",
            "",
            "2024-11-21T05:26:34Z",
            "",
            "",
            "2024-11-21T05:26:34Z",
            FlickrMediaDTO(""),
            "",
            ""
        )

        assert(i1.getFormattedAuthor() == "DAYLAN SANTIAGO")
        assert(i2.getFormattedAuthor() == "IRON MAN")

    }
}
