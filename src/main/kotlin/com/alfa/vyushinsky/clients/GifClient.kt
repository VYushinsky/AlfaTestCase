package com.alfa.vyushinsky.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import java.net.URI

@FeignClient(url = "https://placeholder", name = "gifClient")
interface GifClient {

    @GetMapping
    fun getGifURI(uri: URI): ResponseEntity<ByteArray>

}