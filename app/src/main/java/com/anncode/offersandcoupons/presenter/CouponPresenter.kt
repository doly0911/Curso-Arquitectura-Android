package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {
    //Va hacia la Vista
    fun showCoupons(coupons: ArrayList<Coupon>)

    //Va hacia el interactor
    fun getCoupons()
}