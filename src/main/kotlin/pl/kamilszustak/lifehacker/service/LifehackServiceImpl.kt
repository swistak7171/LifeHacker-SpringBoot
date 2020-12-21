package pl.kamilszustak.lifehacker.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import pl.kamilszustak.lifehacker.model.Lifehack
import pl.kamilszustak.lifehacker.repository.LifehackRepository

@Service
class LifehackServiceImpl(
    private val lifehackRepository: LifehackRepository
) : LifehackService {

    override fun save(lifehack: Lifehack) {
        lifehackRepository.save(lifehack)
    }

    override fun getAll(): List<Lifehack> =
        lifehackRepository.findAll()

    override fun getById(id: Long): Lifehack? =
        lifehackRepository.findByIdOrNull(id)
}