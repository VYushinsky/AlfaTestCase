package com.alfa.vyushinsky.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class GifDTO(val data: Data)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Data(val images: Images)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Images(val original: Original)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Original(
    @JsonProperty(value = "url")
    val url: String)