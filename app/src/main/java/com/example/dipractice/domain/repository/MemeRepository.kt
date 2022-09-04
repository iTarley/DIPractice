package com.example.dipractice.domain.repository

import com.example.dipractice.domain.model.MemeModel
import com.example.dipractice.network.ApiInterface
import com.example.dipractice.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.Exception

class MemeRepository(
    private val api:ApiInterface
) {



    suspend fun getMeme():Resource<MemeModel?>{

        return try {
            Resource.loading(null)
            val response = api.getMeme()
            val result = response.body()
            if(response.isSuccessful){
                Resource.success(result)

            }else{
                Resource.error(response.message())
            }
        }catch (e:Exception){
            Resource.error(e.message.toString())
        }
    }
}