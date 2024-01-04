package com.ngts.wappelyzerweb



import retrofit2.Response
import retrofit2.http.POST

interface ApiService {

        @POST ("api/auth/register")
        suspend fun getQuotes() : Response<QuotesApi>
        class  QuotesApi{

        }
}