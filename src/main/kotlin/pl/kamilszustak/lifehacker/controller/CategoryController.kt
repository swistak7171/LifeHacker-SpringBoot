package pl.kamilszustak.lifehacker.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.kamilszustak.lifehacker.model.Category
import pl.kamilszustak.lifehacker.service.CategoryService

@RestController
@RequestMapping("/categories")
@CrossOrigin
class CategoryController(
    private val service: CategoryService,
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<Category>> {
        val categories = service.getAll()

        return ResponseEntity(categories, HttpStatus.OK)
    }
}