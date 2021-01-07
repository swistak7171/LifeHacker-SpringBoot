package pl.kamilszustak.lifehacker.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.kamilszustak.lifehacker.model.Category

@Repository
interface CategoryRepository : JpaRepository<Category, Long>