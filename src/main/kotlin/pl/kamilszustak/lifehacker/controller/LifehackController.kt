package pl.kamilszustak.lifehacker.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pl.kamilszustak.lifehacker.model.Lifehack
import pl.kamilszustak.lifehacker.service.LifehackService

@RestController
@RequestMapping("/lifehacks")
class LifehackController @Autowired constructor(
    private val lifehackService: LifehackService
) {

    @PostMapping
    fun postLifehack(@RequestBody lifehack: Lifehack): ResponseEntity<Unit> {
        lifehackService.saveLifehack(lifehack)

        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getLifehacks(): ResponseEntity<List<Lifehack>> {
        val lifehacks = lifehackService.getAllLifehacks()

        return ResponseEntity(lifehacks, HttpStatus.OK)
    }

    @PostMapping("/rating/{id}")
    fun postLifehackRating(@PathVariable id: Long, @RequestBody rating: Int): ResponseEntity<Unit> {
        val lifehack = lifehackService.getLifehackById(id)
            ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        lifehack.addRating(rating)
        lifehackService.saveLifehack(lifehack)

        return ResponseEntity(HttpStatus.OK)
    }
}