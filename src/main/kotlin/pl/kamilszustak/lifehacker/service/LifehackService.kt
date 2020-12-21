package pl.kamilszustak.lifehacker.service

import pl.kamilszustak.lifehacker.model.Lifehack

interface LifehackService {
    fun save(lifehack: Lifehack)
    fun getAll(): List<Lifehack>
    fun getById(id: Long): Lifehack?
    fun addRating(id: Long, rating: Int): Boolean
}