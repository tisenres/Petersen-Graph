package com.example.petersengraph2.app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.view.View
import com.example.petersengraph2.domain.entity.Edge
import com.example.petersengraph2.domain.entity.Vertex

class PetersenGraphView(
    context: Context,
    var verticesSet: Set<Vertex>,
    var edgeSet: Set<Edge>
): View(context) {

    private val paint: Paint = Paint()
    private lateinit var canvas: Canvas

    init {
        paint.apply {
            color = Color.BLACK
            strokeWidth = 5F
            style = Paint.Style.FILL
            isAntiAlias = true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas

        drawPoints()
        drawEdges()
    }

    private fun drawPoints() {
        verticesSet.map { vertex ->
            Point(vertex.x * 100, vertex.y * 100)
        }.forEach { point ->
            canvas.drawPoint(point.x.toFloat(), point.y.toFloat(), paint)
        }
    }

    private fun drawEdges() {

    }
}