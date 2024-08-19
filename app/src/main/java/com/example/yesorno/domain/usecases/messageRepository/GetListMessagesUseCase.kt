package com.example.yesorno.domain.usecases.messageRepository

import com.example.yesorno.domain.interfaces.repo.MessageRepoInterface
import com.example.yesorno.domain.models.MessageUIState
import javax.inject.Inject

class GetListMessagesUseCase @Inject constructor(private val repo : MessageRepoInterface) {
    suspend fun execute() : Result<List<MessageUIState>?>{
        return repo.getList()
    }
}