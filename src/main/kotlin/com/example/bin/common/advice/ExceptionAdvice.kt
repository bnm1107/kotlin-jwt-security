package com.example.bin.common.advice

import com.example.bin.common.model.response.CommonResult
import com.example.bin.common.service.response.ResponseService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.naming.AuthenticationException

@RestControllerAdvice
class ExceptionAdvice(
    private val responseService: ResponseService,
    private val messageSource: MessageSource
)
{

    @ExceptionHandler(value = [Exception::class])
    @ResponseBody
    fun defaultEeception(request: HttpServletRequest, e: Exception
    ): ResponseEntity<CommonResult> {

        // TODO Logger
        println("Exception endPoint: ${request.method} ${request.requestURI}, "+
        "queryString: ${request.queryString}, "+
        "exception: $e")

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(responseService.failResult(
                getMessage("unKnown.code").toInt(),
                getMessage("unKnown.message")
            ))
    }

    @ExceptionHandler(value = [UserExistExceptionCustom::class])
    @ResponseBody
    fun userExistException(): ResponseEntity<CommonResult> {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(responseService.failResult(
                getMessage("existingUser.code").toInt(),
                getMessage("existingUser.message")
            ))
    }

    @ExceptionHandler(value = [UserNotFoundExceptionCustom::class])
    fun userNotFoundException(): ResponseEntity<CommonResult> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(responseService.failResult(
                getMessage("userNotFound.code").toInt(),
                getMessage("userNotFound.message")))
    }

    @ExceptionHandler(value = [PasswordNotMatchExceptionCustom::class])
    fun passwordNotMatchException(): ResponseEntity<CommonResult> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(responseService.failResult(
                getMessage("passwordNotFound.code").toInt(),
                getMessage("passwordNotFound.message")))
    }

    @ExceptionHandler(value = [AuthenticationException::class])
    fun authenticationEntryPointException(): ResponseEntity<CommonResult> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(responseService.failResult(
                getMessage("entryPointException.code").toInt(),
                getMessage("entryPointException.message")))
    }

    @ExceptionHandler(value = [AccessDeniedException::class])
    fun accessDeniedException(): ResponseEntity<CommonResult> {
        return ResponseEntity
            .status(HttpStatus.FORBIDDEN)
            .body(responseService.failResult(
                getMessage("accessDenied.code").toInt(),
                getMessage("accessDenied.message")))
    }


    private fun getMessage(code: String): String {
        return messageSource.getMessage(code, null,
            LocaleContextHolder.getLocale())
    }
}