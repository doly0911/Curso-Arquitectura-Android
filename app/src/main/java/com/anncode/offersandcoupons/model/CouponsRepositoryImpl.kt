package com.anncode.offersandcoupons.model

import android.util.Log
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponsRepositoryImpl(var couponPresenter: CouponPresenter): CouponsRepository {

    //LOGICA FINAL de conexión
    override fun getCouponsAPI() {
        val coupons = ArrayList<Coupon>()

        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons.add(coupon)
                }
                couponPresenter.showCoupons(coupons)
            }


        })
    }
}