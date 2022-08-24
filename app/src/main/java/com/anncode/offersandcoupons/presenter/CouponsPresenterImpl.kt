package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponsInteractor
import com.anncode.offersandcoupons.model.CouponsInteractorImpl
import com.anncode.offersandcoupons.view.CouponView

class CouponsPresenterImpl(var couponView: CouponView): CouponPresenter {
    // Necesitamos una instancia de la Vista (por el constructor)
    // Y del Interactor para comunicarnos bidireccionalmente
    private var couponInteractor: CouponsInteractor = CouponsInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        couponView.showCoupon(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}