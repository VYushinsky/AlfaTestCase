package com.alfa.vyushinsky.clients

import com.alfa.vyushinsky.dto.GifDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(url = "\${giphy.url}", name = "giphyClient")
interface GiphyClient {

    @GetMapping("/random")
    fun getGif(@RequestParam api_key: String, @RequestParam tag: String): ResponseEntity<GifDTO>

}