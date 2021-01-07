package pl.kamilszustak.lifehacker.service

import pl.kamilszustak.lifehacker.model.Category

interface CategoryService {
    fun getAll(): List<Category>
    fun add(category: Category)
    fun addAll(categories: Iterable<Category>)
    fun deleteAll()
}