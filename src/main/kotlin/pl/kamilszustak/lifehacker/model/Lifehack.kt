package pl.kamilszustak.lifehacker.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "lifehacks")
data class Lifehack(
    @Column(name = "content")
    @JsonProperty("content")
    val content: String = "",

    @Column(name = "category_id")
    @JsonProperty("category_id")
    val categoryId: Long? = null,
) : DatabaseEntity() {

    @Column(name = "rating")
    @JsonProperty("rating")
    var rating: Double = 0.0
        private set

    @Column(name = "rates_number")
    @JsonProperty("rates_number")
    var ratesNumber: Int = 0
        private set

    fun addRating(rating: Int): Boolean {
        if (rating !in 1..5) {
            return false
        }

        val sum = (this.rating * ratesNumber) + rating
        this.rating = sum / (++ratesNumber)

        return true
    }
}