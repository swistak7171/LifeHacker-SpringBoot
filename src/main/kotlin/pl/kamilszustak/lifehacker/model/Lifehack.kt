package pl.kamilszustak.lifehacker.model

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "lifehacks")
data class Lifehack(
    val content: String = ""
) : DatabaseEntity() {

    var rating: Double = 1.0
        private set

    var ratesNumber: Int = 0
        private set

    fun addRating(rating: Int) {
        val sum = (this.rating * ratesNumber) + rating
        this.rating = sum / (++ratesNumber)
    }
}