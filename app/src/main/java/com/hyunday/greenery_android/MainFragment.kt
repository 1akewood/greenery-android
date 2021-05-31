package com.hyunday.greenery_android

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.addListener

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_main, null)
        var rocketIcon: ImageView = view.findViewById(R.id.rocketIcon)
        val layoutParams = rocketIcon.layoutParams as ConstraintLayout.LayoutParams
        val startAngle = layoutParams.circleAngle
        val endAngle = startAngle + 360

        val anim = ValueAnimator.ofFloat(startAngle, endAngle)
        anim.addUpdateListener { valueAnimator ->
            val animatedValue = valueAnimator.animatedValue as Float
            val layoutParams = rocketIcon.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.circleAngle = animatedValue
            rocketIcon.layoutParams = layoutParams
            rocketIcon.rotation = (animatedValue % 360 - 270)
        }

        anim.duration = 2000

        anim.interpolator = LinearInterpolator()
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.start()

        return view
    }
}