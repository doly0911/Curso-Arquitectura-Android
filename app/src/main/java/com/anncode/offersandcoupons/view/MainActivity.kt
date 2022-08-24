package com.anncode.offersandcoupons.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.ApiAdapter
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.presenter.CouponsPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {

    private lateinit var couponsPresenter: CouponPresenter
    private lateinit var rvCoupons: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Instancia del Presenter para llamar getCoupons()
        couponsPresenter = CouponsPresenterImpl(this)
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons.layoutManager = LinearLayoutManager(this)

        getCoupons()

    }

    override fun showCoupon(coupons: ArrayList<Coupon>) {
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
    }

    override fun getCoupons() {
        couponsPresenter.getCoupons()
    }
}
