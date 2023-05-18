package com.cruz.republicservices.data.remote.client

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitProvider : IRetrofitProvider {

    override val baseUrl: String = "https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/"

    override val moshi: Moshi = Moshi.Builder().build()

    override val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

interface IRetrofitProvider {
    val baseUrl: String

    val moshi: Moshi

    val retrofit: Retrofit
}
