package pl.kamilszustak.lifehacker.service

import pl.kamilszustak.lifehacker.model.Lifehack

interface LifehackService {

    fun saveLifehack(lifehack: Lifehack)

    fun getAllLifehacks(): List<Lifehack>

    fun getLifehackById(id: Long): Lifehack?
}