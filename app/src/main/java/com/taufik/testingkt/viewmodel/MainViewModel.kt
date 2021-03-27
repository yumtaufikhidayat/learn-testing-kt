package com.taufik.testingkt.viewmodel

import com.taufik.testingkt.model.CuboidModel

class MainViewModel(private val cuboidModel: CuboidModel) {

    fun getVolume() = cuboidModel.getVolume()

    fun getCircumference() = cuboidModel.getCircumference()

    fun getSurfaceArea() = cuboidModel.getSurfaceArea()

    fun save(w: Double, l: Double, h: Double) {
        cuboidModel.save(w, l, h)
    }
}