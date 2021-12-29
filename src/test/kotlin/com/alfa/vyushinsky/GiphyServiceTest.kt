package com.alfa.vyushinsky

import com.alfa.vyushinsky.clients.GiphyClient
import com.alfa.vyushinsky.dto.Data
import com.alfa.vyushinsky.dto.GifDTO
import com.alfa.vyushinsky.dto.Images
import com.alfa.vyushinsky.dto.Original
import com.alfa.vyushinsky.services.ExchangeRateService
import com.alfa.vyushinsky.services.GiphyService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


@SpringBootTest
class GiphyServiceTest {

    @MockBean
    private val rateService: ExchangeRateService? = null

    @MockBean
    private val giphyClient: GiphyClient? = null

    @Autowired
    private val giphyService: GiphyService? = null


    @Test
    fun getRichGif() {
        Mockito.`when`(rateService!!.getLatestCurrency(Mockito.anyString()))
            .thenReturn(ResponseEntity(HttpStatus.OK))

        val gifResponse = GifDTO(data = Data(images = Images(original = Original("url_to_gif"))))
        Mockito.`when`(giphyClient!!.getGif(Mockito.anyString(), Mockito.anyString()))
            .thenReturn(ResponseEntity.ok(gifResponse))
        val response: GifDTO? = giphyService!!.getGif("rich").body
        assertEquals("url_to_gif", response!!.data.images.original.url)
    }
}