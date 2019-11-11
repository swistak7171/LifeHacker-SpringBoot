package pl.kamilszustak.lifehacker.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class DatabaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val createdAt: Date = Date()

    @LastModifiedDate
    @Column(nullable = false)
    val updatedAt: Date = Date()
}