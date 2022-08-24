package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponsInteractorImpl(var couponPresenter: CouponPresenter): CouponsInteractor {

    //Necesita instancia del presenter y del repository
    var couponsRepository: CouponsRepository = CouponsRepositoryImpl(couponPresenter)

    //Va hacia el repository (IDA)
    override fun getCouponsAPI() {
        couponsRepository.getCouponsAPI()
    }
}