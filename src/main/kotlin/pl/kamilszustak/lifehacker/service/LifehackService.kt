package pl.kamilszustak.lifehacker.service

import pl.kamilszustak.lifehacker.model.Lifehack

interface LifehackService {
    fun add(lifehack: Lifehack)
    fun getAll(query: String? = null, categoryId: Long? = null): List<Lifehack>
    fun getById(id: Long): Lifehack?
    fun addRating(id: Long, rating: Int): Boolean
}