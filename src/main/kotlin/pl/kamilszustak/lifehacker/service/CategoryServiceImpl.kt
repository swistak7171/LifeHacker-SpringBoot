package pl.kamilszustak.lifehacker.service

import org.springframework.stereotype.Service
import pl.kamilszustak.lifehacker.model.Category
import pl.kamilszustak.lifehacker.repository.CategoryRepository

@Service
class CategoryServiceImpl(
    private val repository: CategoryRepository,
) : CategoryService {

    override fun getAll(): List<Category> =
        repository.findAll()

    override fun add(category: Category) {
        repository.save(category)
    }

    override fun addAll(categories: Iterable<Category>) {
        repository.saveAll(categories)
    }

    override fun deleteAll() {
        repository.deleteAll()
    }
}