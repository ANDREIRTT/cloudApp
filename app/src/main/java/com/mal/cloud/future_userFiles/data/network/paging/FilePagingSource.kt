package com.mal.cloud.future_userFiles.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mal.cloud.future_userFiles.data.network.paging.data.FilePagingData
import com.mal.cloud.future_userFiles.data.network.pojo.StorageFile
import com.mal.cloud.future_userFiles.data.network.service.FileService
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FilePagingSource @Inject constructor(
    private val fileService: FileService
) : PagingSource<FilePagingData, StorageFile>() {
    override fun getRefreshKey(state: PagingState<FilePagingData, StorageFile>): FilePagingData? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<FilePagingData>): LoadResult<FilePagingData, StorageFile> {
        return try {
            val data = fileService.getFiles(
                params.key?.page ?: 0,
                params.loadSize
            )

            if (!data.isSuccessful || data.body() == null) {
                return LoadResult.Error(Exception("response is not success"))
            }
            val response = data.body()

            LoadResult.Page(
                data = response!!.storageFile,
                prevKey = null,
                nextKey = if (response.isLastPage) null else FilePagingData(
                    response.page + 1,
                    response.size
                )
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}