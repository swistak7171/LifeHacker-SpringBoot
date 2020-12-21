package pl.kamilszustak.lifehacker.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class DatabaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    val id: Long = 0

    @CreatedDate
    @Column(name = "creation_date", nullable = false, updatable = false)
    @JsonProperty("creation_date")
    val creationDate: Date = Date()

    @LastModifiedDate
    @Column(name = "modification_date", nullable = false)
    @JsonProperty("modification_date")
    val modificationDate: Date = Date()
}