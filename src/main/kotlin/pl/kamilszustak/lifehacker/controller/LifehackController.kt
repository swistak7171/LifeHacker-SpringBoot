package pl.kamilszustak.lifehacker.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pl.kamilszustak.lifehacker.model.Lifehack
import pl.kamilszustak.lifehacker.service.LifehackService

@RestController
@RequestMapping("/lifehacks")
@CrossOrigin
class LifehackController(
    private val lifehackService: LifehackService
) {
    @PostMapping
    fun postLifehack(@RequestBody lifehack: Lifehack): ResponseEntity<Unit> {
        lifehackService.add(lifehack)

        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllLifehacks(): ResponseEntity<List<Lifehack>> {
        val lifehacks = lifehackService.getAll()

        return ResponseEntity(lifehacks, HttpStatus.OK)
    }

    @PostMapping("/{id}/rating")
    fun postLifehackRating(@PathVariable("id") id: Long, @RequestBody rating: Int): ResponseEntity<Unit> {
        val added = lifehackService.addRating(id, rating)
        if (!added) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        return ResponseEntity(HttpStatus.OK)
    }
}