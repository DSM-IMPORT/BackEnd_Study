package com.example.global.filter

import com.example.global.Exception.InternalServerErrorException
import com.example.global.error.CustomException
import com.example.global.error.ErrorProperty
import com.example.global.error.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    @Throws(IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is CustomException -> sendErrorMessage(response, e.errorProperty)
                else -> sendErrorMessage(response, InternalServerErrorException.EXCEPTION.errorProperty)
            }
        }
    }

    @Throws(IOException::class)
    private fun sendErrorMessage(response: HttpServletResponse, errorProperty: ErrorProperty) {

        response.status = errorProperty.status()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(ErrorResponse.of(errorProperty)))
    }
}