package com.anwesh.uiprojects.fullscreencoloredlineview

/**
 * Created by anweshmishra on 26/06/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val colors : Array<String> = arrayOf("#3F51B5", "#4CAF50", "#F44336", "#2196F3", "#009688")
val parts : Int = 2
val scGap : Float = 0.02f
val strokeFactor : Float = 90f
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawDoubleCallback(cb : ( Float) -> Unit) {
    for (j in 0..(parts - 1)) {
        save()
        cb( 1f - 2 * j)
        restore()
    }
}

fun Canvas.drawFullScreenColoredLine(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, 2)
    val sf2 : Float = sf.divideScale(1, 2)
    drawDoubleCallback {
        scale(it, 1f)
        drawLine(0f, 0f, w * sf1 * 0.5f, 0f, paint)
    }
    drawDoubleCallback {
        scale(1F, it)
        drawLine(0f, 0f, 0f, h * sf2 * 0.5f, paint)
    }
}

fun Canvas.drawFSCLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = Color.parseColor(colors[i])
    save()
    translate(w / 2, h / 2)
    drawFullScreenColoredLine(scale, w, h, paint)
    restore()
}


class FullScreenColoredLineView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}