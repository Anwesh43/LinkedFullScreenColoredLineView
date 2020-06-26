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
