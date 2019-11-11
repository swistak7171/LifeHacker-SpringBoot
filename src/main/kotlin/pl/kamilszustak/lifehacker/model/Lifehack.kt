package pl.kamilszustak.lifehacker.model

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "lifehacks")
data class Lifehack(
    var content: String = ""
) : DatabaseEntity() {

    var rating: Double = 1.0
    var ratesNumber: Int = 0

    fun addRating(rating: Int) {
        val sum = (this.rating * ratesNumber) + rating
        this.rating = sum / (++ratesNumber)
    }
}