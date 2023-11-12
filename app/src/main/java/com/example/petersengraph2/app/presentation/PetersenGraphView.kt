package com.example.petersengraph2.app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import java.lang.Math.cos
import java.lang.Math.sin

class PetersenGraphView(
    context: Context,
    var verticesSet: MutableList<Int>,
    var edgeSet: MutableList<Pair<Int, Int>>
): View(context) {

    private val paint: Paint = Paint()

    init {
        paint.apply {
            color = Color.BLACK
            strokeWidth = 10F
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2F
        val centerY = height / 2F

        drawPentagon(canvas, centerX, centerY, 100F)

    }

    private fun drawPentagon(canvas: Canvas, centerX: Float, centerY: Float, radius: Float) {
        val sides = 5
        val angle = 360 / sides.toFloat()

        var startX = centerX + radius * cos(Math.toRadians(90.0)).toFloat()
        var startY = centerY - radius * sin(Math.toRadians(90.0)).toFloat()
        canvas.drawPoint(startX, startY, paint)

        for (i in 1 until sides) {
            val x = centerX + radius * cos(Math.toRadians((90 + i * angle).toDouble())).toFloat()
            val y = centerY - radius * sin(Math.toRadians((90 + i * angle).toDouble())).toFloat()
            canvas.drawPoint(x, y, paint)
            canvas.drawLine(startX, startY, x, y, paint)
            startX = x
            startY = y
        }

        canvas.drawLine(startX, startY, centerX + radius * cos(Math.toRadians(90.0)).toFloat(), centerY - radius * sin(Math.toRadians(90.0)).toFloat(), paint)
    }
}