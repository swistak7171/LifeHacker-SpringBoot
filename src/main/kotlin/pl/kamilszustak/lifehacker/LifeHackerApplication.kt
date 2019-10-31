package pl.kamilszustak.lifehacker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LifeHackerApplication

fun main(args: Array<String>) {
    runApplication<LifeHackerApplication>(*args)
}
