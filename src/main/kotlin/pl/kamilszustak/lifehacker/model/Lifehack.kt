package pl.kamilszustak.lifehacker.model

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "lifehacks")
data class Lifehack(
    var text: String = ""
) : DatabaseEntity() {

    var rating: Double = 0.0
    var ratesNumber: Int = 0

    fun addRating(rating: Int) {
        val sum = (this.rating * ratesNumber) + rating
        this.rating = sum / (++ratesNumber)
    }
}