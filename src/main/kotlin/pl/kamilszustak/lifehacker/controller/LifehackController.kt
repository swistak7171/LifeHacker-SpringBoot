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
        lifehackService.save(lifehack)

        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun getLifehacks(@RequestParam(name = "minimum_rating", required = false, defaultValue = "1.0") minimumRating: Double): ResponseEntity<List<Lifehack>> {
        val lifehacks = lifehackService.getAll()
            .asSequence()
            .filter {
                it.rating >= minimumRating
            }
            .toList()

        return ResponseEntity(lifehacks, HttpStatus.OK)
    }

    @PostMapping("/rating/{id}")
    fun postLifehackRating(@PathVariable id: Long, @RequestBody rating: Int): ResponseEntity<Unit> {
        val lifehack = lifehackService.getById(id)
            ?: return ResponseEntity(HttpStatus.NOT_FOUND)

        lifehack.addRating(rating)
        lifehackService.save(lifehack)

        return ResponseEntity(HttpStatus.OK)
    }
}