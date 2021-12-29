package com.alfa.vyushinsky.services

import org.springframework.http.ResponseEntity
import java.net.URI

interface  DownloadGifService {
    fun getGifByURI(uri: URI): ResponseEntity<ByteArray>
}