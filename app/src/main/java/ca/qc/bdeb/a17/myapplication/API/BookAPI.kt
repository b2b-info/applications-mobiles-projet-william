package ca.qc.bdeb.a17.myapplication.API
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BookAPI {
    @GET("search.json")
    suspend fun getSearch(@Query("q") q : String) : Response<BookList>

}