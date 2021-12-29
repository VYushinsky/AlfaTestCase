package com.alfa.vyushinsky.exception

import com.alfa.vyushinsky.dto.ExceptionDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class HandlerException {

    @ExceptionHandler(CurrencyException::class)
    fun currencyException(e: Exception): ResponseEntity<ExceptionDTO> {
        val errorDetails = ExceptionDTO(e.message!!)
        return ResponseEntity(errorDetails, HttpStatus.FORBIDDEN)
    }

}