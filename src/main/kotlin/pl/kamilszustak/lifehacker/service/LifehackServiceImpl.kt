package pl.kamilszustak.lifehacker.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import pl.kamilszustak.lifehacker.model.Lifehack
import pl.kamilszustak.lifehacker.repository.LifehackRepository

@Service
class LifehackServiceImpl @Autowired constructor(
    private val lifehackRepository: LifehackRepository
) : LifehackService {

    override fun saveLifehack(lifehack: Lifehack) {
        lifehackRepository.save(lifehack)
    }

    override fun getAllLifehacks(): List<Lifehack> =
        lifehackRepository.findAll()

    override fun getLifehackById(id: Long): Lifehack? =
        lifehackRepository.findByIdOrNull(id)
}