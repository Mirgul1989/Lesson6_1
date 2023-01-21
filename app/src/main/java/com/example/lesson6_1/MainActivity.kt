package com.example.lesson6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lesson6_1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = arrayListOf(
        "https://st3.depositphotos.com/7340112/15280/i/1600/depositphotos_152809206-stock-photo-mountain-peaks-in-cape-town.jpg",
        "https://i.pinimg.com/474x/98/63/d6/9863d6c8548eca3e71b865a942dc10e3.jpg",
        "https://i.pinimg.com/474x/ce/e1/bb/cee1bb54ff5a8c7051956b98513a64fa.jpg",
        "https://i.pinimg.com/564x/77/d7/6f/77d76f9286c2f2bbf530f4da3b3f14be.jpg",
        "https://i.pinimg.com/474x/27/9b/42/279b42875142af1b587b2ec92d645d8c.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnSubmit.setOnClickListener {
                if (Patterns.WEB_URL.matcher(binding.editText.text.toString()).matches()) {
                    data.add(binding.editText.text.toString())
                    binding.editText.text.clear()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.is_not_image),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            btnRandom.setOnClickListener {
                binding.image.loadImage(data[Random.nextInt(data.size)])
            }
        }
    }

    private fun View.loadImage(url: String) {
        Glide.with(this).load(url).circleCrop().into(this as ImageView)
    }

}

