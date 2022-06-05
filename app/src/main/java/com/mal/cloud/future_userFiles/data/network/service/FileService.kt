package com.mal.cloud.future_userFiles.data.network.service

import com.mal.cloud.future_userFiles.data.network.pojo.FileResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FileService {

    @GET("user/files")
    suspend fun getFiles(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<FileResponse>
}