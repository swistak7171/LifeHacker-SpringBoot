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
    @Column(name = "creation_date", nullable = false, updatable = false)
    val creationDate: Date = Date()

    @LastModifiedDate
    @Column(name = "modification_date", nullable = false)
    val modificationDate: Date = Date()
}