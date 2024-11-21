package com.example.flickr_code_challenge.utils

import com.example.flickr_code_challenge.data.remote.models.FlickrImageDTO
import org.jsoup.Jsoup
import java.time.ZonedDateTime


fun FlickrImageDTO.getFormattedDate():String{
    val date = ZonedDateTime.parse(this.published)

    val str = "${date.dayOfMonth} ${date.month} ${date.year}"

    return str
}

fun FlickrImageDTO.getFormattedAuthor():String{
    return this.author.substringAfter("(").substringBefore(")")
}

