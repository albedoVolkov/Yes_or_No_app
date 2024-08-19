package com.example.yesorno.domain.usecases.messageRepository

import com.example.yesorno.domain.interfaces.repo.MessageRepoInterface
import com.example.yesorno.domain.models.MessageUIState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListMessagesFlowUseCase @Inject constructor(private val repo : MessageRepoInterface) {
    fun execute() : Flow<List<MessageUIState>?> = repo.getListFlow()
}