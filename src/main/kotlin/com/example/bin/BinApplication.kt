package com.example.bin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BinApplication

fun main(args: Array<String>) {
	runApplication<BinApplication>(*args)
}
