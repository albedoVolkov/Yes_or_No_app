package com.example.yesorno.domain.usecases.messageRepository

import com.example.yesorno.domain.interfaces.repo.MessageRepoInterface
import com.example.yesorno.domain.models.MessageUIState
import javax.inject.Inject

class GetMessageByIdUseCase @Inject constructor(private val repo : MessageRepoInterface) {
    suspend fun execute(id : String) : Result<MessageUIState?>{
        return repo.getById(id)
    }
}