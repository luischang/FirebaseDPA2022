package dev.lchang.firebasedpa2022.ui.fragments.`interface`

import dev.lchang.firebasedpa2022.ui.fragments.model.MascotaModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("mascotaperdida.php")
    fun listarMascota(): Call<List<MascotaModel>>
}