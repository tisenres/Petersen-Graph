package com.example.petersengraph2.app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Math.cos
import java.lang.Math.sin

class PetersenGraphView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr) {

    var verticesSet: List<Int> = emptyList()
    var edgeSet: List<Pair<Int, Int>> = emptyList()
    var n = 0
    var k = 0

    private val paint: Paint = Paint().apply {
        color = 0xFF000000.toInt()
        strokeWidth = 5f
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = centerX.coerceAtMost(centerY) - 10f

        for ((start, end) in edgeSet) {
            val startX = centerX + radius * cos(2 * Math.PI * start / n).toFloat()
            val startY = centerY + radius * sin(2 * Math.PI * start / n).toFloat()

            val endX = centerX + radius * cos(2 * Math.PI * end / n).toFloat()
            val endY = centerY + radius * sin(2 * Math.PI * end / n).toFloat()

            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }
}