package pl.kamilszustak.lifehacker.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.kamilszustak.lifehacker.model.Lifehack

@Repository
interface LifehackRepository : JpaRepository<Lifehack, Long>