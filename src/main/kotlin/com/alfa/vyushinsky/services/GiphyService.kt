package com.alfa.vyushinsky.services

import com.alfa.vyushinsky.dto.GifDTO
import org.springframework.http.ResponseEntity

interface GiphyService {
    fun getGif(tag: String): ResponseEntity<GifDTO>
}