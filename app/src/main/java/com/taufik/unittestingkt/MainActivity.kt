package com.taufik.unittestingkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.taufik.unittestingkt.databinding.ActivityMainBinding
import com.taufik.unittestingkt.model.CuboidModel
import com.taufik.unittestingkt.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        initOnClickListener()
    }

    private fun initViewModel() {
        mainViewModel = MainViewModel(CuboidModel())
    }

    private fun initOnClickListener() {
        binding.apply {
            btnSave.setOnClickListener(this@MainActivity)
            btnCalculateSurfaceArea.setOnClickListener(this@MainActivity)
            btnCalculateCircumference.setOnClickListener(this@MainActivity)
            btnCalculateVolume.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View) {
        binding.apply {
            val length = etLength.text.toString().trim()
            val width = etWidth.text.toString().trim()
            val height = etHeight.text.toString().trim()

            when {
                TextUtils.isEmpty(length) -> {
                    etLength.error = "Field can't be blank"
                }

                TextUtils.isEmpty(width) -> {
                    etWidth.error = "Field can't be blank"
                }

                TextUtils.isEmpty(height) -> {
                    etHeight.error = "Field can't be blank"
                }

                else -> {
                    val valueLength = length.toDouble()
                    val valueWidth = width.toDouble()
                    val valueHeight = height.toDouble()

                    when (v.id) {
                        R.id.btnSave -> {
                            mainViewModel.save(valueWidth, valueLength, valueHeight)
                            visibleButton()
                        }

                        R.id.btnCalculateCircumference -> {
                            binding.apply {
                                tvResult.text = mainViewModel.getCircumference().toString()
                                goneButton()
                            }
                        }

                        R.id.btnCalculateSurfaceArea -> {
                            binding.apply {
                                tvResult.text = mainViewModel.getSurfaceArea().toString()
                                goneButton()
                            }
                        }

                        R.id.btnCalculateVolume -> {
                            binding.apply {
                                tvResult.text = mainViewModel.getVolume().toString()
                                goneButton()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun visibleButton() {
        binding.apply {
            btnCalculateVolume.visibility = View.VISIBLE
            btnCalculateCircumference.visibility = View.VISIBLE
            btnCalculateSurfaceArea.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        }
    }

    private fun goneButton() {
        binding.apply {
            btnCalculateVolume.visibility = View.GONE
            btnCalculateCircumference.visibility = View.GONE
            btnCalculateSurfaceArea.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
        }
    }
}