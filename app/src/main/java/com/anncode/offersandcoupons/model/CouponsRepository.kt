package com.anncode.offersandcoupons.model

interface CouponsRepository {

    //LLAMA AL PRESENTER PARA ENVIAR LOS CUPONES OBTENIDOS (Necesita una instancia del CouponsPresenter)
    fun getCouponsAPI()

}