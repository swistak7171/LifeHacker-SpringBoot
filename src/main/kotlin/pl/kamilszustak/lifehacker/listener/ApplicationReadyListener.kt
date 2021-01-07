package pl.kamilszustak.lifehacker.listener

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import pl.kamilszustak.lifehacker.model.Category
import pl.kamilszustak.lifehacker.service.CategoryService

@Component
class ApplicationReadyListener(
    private val service: CategoryService,
) {
    @EventListener(ApplicationReadyEvent::class)
    fun addCategories() {
        val categories = Category.default
        with(service) {
            deleteAll()
            addAll(categories)
        }
    }
}