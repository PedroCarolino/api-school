package com.app.apiFitness.service

import com.app.apiFitness.controller.dto.request.TrainingSheetCreateRequestDTO

interface TrainingSheetService {
    fun searchAllTrainingSheets(id: Long?) : Any
    fun create(trainingSheetDTO: TrainingSheetCreateRequestDTO)

}