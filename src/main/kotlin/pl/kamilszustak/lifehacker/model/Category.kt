package pl.kamilszustak.lifehacker.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "categories")
data class Category(
    @Column(name = "name")
    @JsonProperty("name")
    val name: String = ""
) : DatabaseEntity() {

    companion object {
        val default: List<Category>
            get() = listOf(
                Category("Health"),
                Category("Food"),
                Category("Work"),
                Category("School")
            )
    }
}