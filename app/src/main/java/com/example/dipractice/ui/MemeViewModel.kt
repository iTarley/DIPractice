package com.example.dipractice.ui

import androidx.lifecycle.ViewModel
import com.example.dipractice.domain.model.MemeModel
import com.example.dipractice.domain.repository.MemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


@HiltViewModel
class MemeViewModel @Inject constructor(
    private val repository: MemeRepository
) : ViewModel() {



    fun getMeme() = flow<List<MemeModel.Data.Meme?>?>{
        val response = repository.getMeme().data?.data?.memes
        emit(response)
    }
}