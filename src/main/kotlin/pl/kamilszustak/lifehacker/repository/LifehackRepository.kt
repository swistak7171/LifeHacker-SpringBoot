package pl.kamilszustak.lifehacker.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import pl.kamilszustak.lifehacker.model.Lifehack

@Repository
interface LifehackRepository : JpaRepository<Lifehack, Long> {
    @Query(
        value = "SELECT * FROM lifehacks WHERE (:query IS NULL OR LOWER(content) LIKE '%' || LOWER(:query) || '%')" +
            "AND (:category_id IS NULL OR category_id = :category_id)",
        nativeQuery = true
    )
    fun findAllWhereContentLike(
        @Param("query") query: String?,
        @Param("category_id") categoryId: Long?
    ): List<Lifehack>
}