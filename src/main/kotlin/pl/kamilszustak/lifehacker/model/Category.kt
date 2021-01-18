package pl.kamilszustak.lifehacker.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @JsonProperty("id")
    val id: Long = 0,

    @Column(
        name = "name",
        nullable = false
    )
    @JsonProperty("name")
    val name: String = "",
) {
    @CreatedDate
    @Column(
        name = "creation_date",
        nullable = false,
        updatable = false
    )
    @JsonProperty("creation_date")
    val creationDate: Date = Date()

    @LastModifiedDate
    @Column(
        name = "modification_date",
        nullable = false
    )
    @JsonProperty("modification_date")
    val modificationDate: Date = Date()

    companion object {
        val default: List<Category>
            get() = listOf(
                Category(1, "Health"),
                Category(2, "Food"),
                Category(3, "Work"),
                Category(4, "School")
            )
    }
}