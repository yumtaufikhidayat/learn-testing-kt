package com.taufik.testingkt.model

class CuboidModel {

    private var length = 0.0
    private var width = 0.0
    private var height = 0.0

    fun getVolume(): Double = length * width * height

    fun getSurfaceArea(): Double {
        val wl = width * length
        val wh = width * height
        val lh = length * height

        return 2 * (wl + wh + lh)
    }

    fun getCircumference(): Double = 4 * (length + width + height)

    fun save(width: Double, length: Double, height: Double) {
        this.width = width
        this.length = length
        this.height = height
    }
}