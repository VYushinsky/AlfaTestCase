package com.alfa.vyushinsky.services.implementation

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import com.alfa.vyushinsky.clients.GiphyClient
import com.alfa.vyushinsky.settings.GiphySetting
import com.alfa.vyushinsky.dto.GifDTO
import com.alfa.vyushinsky.services.GiphyService

@Service
class GiphyServiceImpl(val giphyClient: GiphyClient,
                       val giphySetting: GiphySetting
): GiphyService {

    override fun getGif(tag: String): ResponseEntity<GifDTO> {
       return giphyClient.getGif(giphySetting.api_key, tag)
    }


}