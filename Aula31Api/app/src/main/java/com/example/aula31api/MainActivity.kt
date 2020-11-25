package com.example.aula31api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aula31api.Repository.IEndpoint
import com.example.aula31api.model.LocationModel
import com.example.aula31api.model.RickMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var client = getRetrofitInstance(BASE_URL)

//        var endpoint = client.create(CharacterModel::class.java)
        var endpoint = client.create(IEndpoint::class.java)

        endpoint.obterLocalizacao().enqueue(object: Callback<RickMortyResponse<LocationModel>> {
            override fun onFailure(call: Call<RickMortyResponse<LocationModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RickMortyResponse<LocationModel>>,
                response: Response<RickMortyResponse<LocationModel>>
            ) {
                val resultado = response.body()

                Toast.makeText(this@MainActivity, resultado!!.results[0].nome, Toast.LENGTH_LONG).show()
            }

        })

    }

    fun getRetrofitInstance(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object{
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}