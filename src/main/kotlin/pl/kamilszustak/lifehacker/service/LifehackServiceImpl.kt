package pl.kamilszustak.lifehacker.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import pl.kamilszustak.lifehacker.model.Lifehack
import pl.kamilszustak.lifehacker.repository.LifehackRepository

@Service
class LifehackServiceImpl(
    private val lifehackRepository: LifehackRepository
) : LifehackService {

    override fun add(lifehack: Lifehack) {
        lifehackRepository.save(lifehack)
    }

    override fun getAll(query: String?, categoryId: Long?): List<Lifehack> {
        return lifehackRepository.findAllWhereContentLike(query, categoryId)

        return if (query == null) {
            lifehackRepository.findAll()
        } else {
            lifehackRepository.findAllWhereContentLike(query, categoryId)
        }
    }

    override fun getById(id: Long): Lifehack? =
        lifehackRepository.findByIdOrNull(id)

    override fun addRating(id: Long, rating: Int): Boolean {
        val lifehack = getById(id) ?: return false
        lifehack.addRating(rating)
        add(lifehack)

        return true
    }
}