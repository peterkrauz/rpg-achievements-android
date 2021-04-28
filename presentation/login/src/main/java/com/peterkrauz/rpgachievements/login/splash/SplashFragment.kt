package com.peterkrauz.rpgachievements.login.splash

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.peterkrauz.presentation.common_ui.base.BaseFragment
import com.peterkrauz.presentation.common_ui.extensions.paintStatusBar
import com.peterkrauz.rpgachievements.login.R
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun setupView() {
        super.setupView()
        paintStatusBar(R.color.darkGrey)

        val animation = AnimationUtils.loadAnimation(context, R.anim.fade_out).apply {
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {}
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) {
                    textViewSplash.isVisible = false
                    translateAppLogo()
                }
            })
        }

        lifecycleScope.launch {
            delay(800)
            textViewSplash.startAnimation(animation)
        }
    }

    private fun translateAppLogo() {
        ObjectAnimator.ofFloat(imageViewSplash, "translationY", -427F).apply {
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(p0: Animator?) {}
                override fun onAnimationEnd(p0: Animator?) {
                    (context as SplashScreenListener).onAnimationsEnd()
                }

                override fun onAnimationCancel(p0: Animator?) {}
                override fun onAnimationStart(p0: Animator?) {}
            })
            duration = 500
            start()
        }
    }
}

interface SplashScreenListener {
    fun onAnimationsEnd()
}
