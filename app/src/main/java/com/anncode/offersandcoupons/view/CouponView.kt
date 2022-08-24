package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponView {
    //Va hacia la vista (REGRESO)
    fun showCoupon(coupons: ArrayList<Coupon>)

    //Va hacia el Presenter (IDA)
    fun getCoupons()
}