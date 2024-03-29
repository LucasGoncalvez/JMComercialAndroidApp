package com.example.jmcomercialapp.d_utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.example.jmcomercialapp.R

@BindingAdapter("imgStatus")
fun bindImgStatus(img: LottieAnimationView, status: MainStatuses?){
    when(status){
        MainStatuses.LOADING -> {
            img.visibility = View.VISIBLE
            img.setAnimation(R.raw.loading)
            img.playAnimation()
        }
        MainStatuses.ERROR -> {
            img.setImageResource(R.drawable.wifi_off)
            img.visibility = View.VISIBLE
        }
        else -> {
            img.visibility = View.GONE
        }
    }
}

@BindingAdapter("textStatus")
fun bindTextStatus(textView: TextView, status: MainStatuses?){
    when(status){
        MainStatuses.LOADING -> {
            textView.visibility = View.VISIBLE
            textView.setText(R.string.textLoading)
        }
        MainStatuses.ERROR -> {
            textView.visibility = View.VISIBLE
            textView.setText(R.string.textErrorConection)
        }
        else -> {
            textView.visibility = View.GONE
        }
    }
}

@BindingAdapter("viewVisibility")
fun bindViewVisibility(view: View, status: MainStatuses?){
    when(status){
        MainStatuses.LOADING -> {
            view.visibility = View.GONE
        }
        MainStatuses.ERROR -> {
            view.visibility = View.GONE
        }
        MainStatuses.DONE -> {
            view.visibility = View.VISIBLE
        }
        else -> {
            view.visibility = View.GONE
        }
    }
}

@BindingAdapter("setImageFromId")
fun bindSetImageFromId(imageView: ImageView, imageId: Int){
    imageView.setImageResource(imageId)
}

@BindingAdapter("viewEnabled")
fun bindViewEnabled(view: View, status: MainStatuses?){
    view.isEnabled = when (status){
        MainStatuses.LOADING -> { false }
        else -> { true }
    }
}
