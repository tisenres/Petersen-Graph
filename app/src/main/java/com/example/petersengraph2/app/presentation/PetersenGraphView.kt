package com.example.petersengraph2.app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.petersengraph2.app.presentation.themes.Theme
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
        strokeWidth = 5f
        isAntiAlias = true
    }

//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//
//        val centerX = width / 2f
//        val centerY = height / 2f
//        val radius = centerX.coerceAtMost(centerY) - 10f
//
//        for ((start, end) in edgeSet) {
//            val startX = centerX + radius * cos(2 * Math.PI * start / n).toFloat()
//            val startY = centerY + radius * sin(2 * Math.PI * start / n).toFloat()
//
//            val endX = centerX + radius * cos(2 * Math.PI * end / n).toFloat()
//            val endY = centerY + radius * sin(2 * Math.PI * end / n).toFloat()
//
//            canvas.drawLine(startX, startY, endX, endY, paint)
//        }
//    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val outerPoints: MutableList<Pair<Float, Float>> = mutableListOf()
        val innerPoints:MutableList<Pair<Float, Float>> = mutableListOf()

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = minOf(centerX, centerY) - 20f // Ensure the graph fits within the view

        // Draw outer vertices
        for (i in verticesSet.indices) {
            val angle = 2 * Math.PI * i / verticesSet.size
            val x = centerX + radius * cos(angle).toFloat()
            val y = centerY + radius * sin(angle).toFloat()

            val point = Pair(x, y)
            outerPoints.add(point)

            canvas.drawCircle(x, y, 10f, paint)
        }

        // Draw inner vertices
        for (i in verticesSet.indices) {
            val angle = 2 * Math.PI * i / verticesSet.size
            val x = centerX + radius * cos(angle).toFloat() / 2
            val y = centerY + radius * sin(angle).toFloat() / 2

            val point = Pair(x, y)
            innerPoints.add(point)

            canvas.drawCircle(x, y, 10f, paint)
        }

        // Draw inner edges
        for (i in verticesSet.indices) {
            val x1 = centerX + radius * cos(2 * Math.PI * i / verticesSet.size).toFloat() / 2
            val y1 = centerY + radius * sin(2 * Math.PI * i / verticesSet.size).toFloat() / 2

            val x2 = centerX + radius * cos(2 * Math.PI * (i + k) / verticesSet.size).toFloat() / 2
            val y2 = centerY + radius * sin(2 * Math.PI * (i + k) / verticesSet.size).toFloat() / 2

            canvas.drawLine(x1, y1, x2, y2, paint)
        }

        // Draw outer edges
        for (i in verticesSet.indices) {

            val x1 = outerPoints[i].first
            val y1 = outerPoints[i].second

            val x2 = outerPoints[(i+1) % verticesSet.size].first
            val y2 = outerPoints[(i+1) % verticesSet.size].second

            canvas.drawLine(x1, y1, x2, y2, paint)
        }

        // Draw edges between inner and outer edges
        for (i in verticesSet.indices) {

            val x1 = innerPoints[i].first
            val y1 = innerPoints[i].second

            val x2 = outerPoints[i].first
            val y2 = outerPoints[i].second

            canvas.drawLine(x1, y1, x2, y2, paint)
        }
    }

    fun setThemeForPaint(theme: Theme) {
        if (theme == Theme.LIGHT) {
            paint.color = Color.BLACK
        } else {
            paint.color = Color.WHITE
        }
    }
}