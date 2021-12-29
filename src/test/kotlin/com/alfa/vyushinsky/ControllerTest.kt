package com.alfa.vyushinsky

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should get 200 status`() {
        mockMvc.perform(get("/api/gif/EUR"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.IMAGE_GIF))
    }

    @Test
    fun `should return 403 status`() {
        mockMvc.perform(get("/api/gif/RUX"))
            .andExpect(status().isForbidden)
    }

}


