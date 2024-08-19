package com.example.yesorno.domain.usecases.messageRepository


import com.example.yesorno.domain.interfaces.repo.MessageRepoInterface
import javax.inject.Inject

class DeleteMessageFromListByIdUseCase @Inject constructor(private val repo : MessageRepoInterface) {
    suspend fun execute(id : String){
        repo.delete(id)
    }
}