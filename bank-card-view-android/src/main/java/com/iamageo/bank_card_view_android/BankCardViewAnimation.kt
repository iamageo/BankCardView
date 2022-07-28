package com.iamageo.bank_card_view_android

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnticipateOvershootInterpolator

fun startAnimation(
    animation: FlipBankCardViewAnimation?,
    view: View,
    bankCardView: BankCardView,
    degree: Int
) {
    var animation = animation
    if (animation != null) {
        animation.setCanContentChange()
        view.startAnimation(animation)
    } else {
        val width: Int = view.getWidth() / 2
        val height: Int = view.getHeight() / 2
        animation = FlipBankCardViewAnimation(0, degree, width, height)
        animation.interpolator = AnticipateOvershootInterpolator()
        animation.duration = 1000
        animation.fillAfter = false
        animation.repeatCount = -1
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {}
            override fun onAnimationRepeat(animation: Animation) {
                (animation as FlipBankCardViewAnimation).cancel()
            }
        })
        animation.setOnContentChangeListener(object : FlipBankCardViewAnimation.OnContentChangeListener {
            override fun contentChange() {
                bankCardView.isFrontCard = !bankCardView.isFrontCard
            }
        })
        view.startAnimation(animation)
    }
}