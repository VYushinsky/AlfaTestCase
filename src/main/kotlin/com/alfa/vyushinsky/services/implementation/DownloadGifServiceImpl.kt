package com.alfa.vyushinsky.services.implementation

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import com.alfa.vyushinsky.clients.GifClient
import com.alfa.vyushinsky.services.DownloadGifService
import java.net.URI

@Service
class DownloadGifServiceImpl(val gifClient: GifClient): DownloadGifService {

    override fun getGifByURI(uri: URI): ResponseEntity<ByteArray> {
        return gifClient.getGifURI(uri)
    }

}