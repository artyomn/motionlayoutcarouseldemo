package io.github.artyomn.motionlayoutcarouseldemo.ui.carousel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.motion.widget.MotionLayout
import io.github.artyomn.motionlayoutcarouseldemo.R

class ViewCarousel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) {

    private var root = LayoutInflater.from(context).inflate(
        R.layout.view_carousel,
        this,
        false
    ) as MotionLayout

    var onPrev: (() -> Unit)? = null
    var onNext: (() -> Unit)? = null

    init {
        addView(root)

        root.setTransitionListener(object : TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(layout: MotionLayout?, id: Int) {
                when (id) {
                    R.id.next -> {
                        println("!!! next")
                        root.setTransitionDuration(0)
                        root.transitionToState(R.id.base)
                        onNext?.invoke()
                    }
                    R.id.prev -> {
                        println("!!! prev")
                        root.setTransitionDuration(0)
                        root.transitionToState(R.id.base)
                        onPrev?.invoke()
                    }
                }
            }
        })
    }

}
