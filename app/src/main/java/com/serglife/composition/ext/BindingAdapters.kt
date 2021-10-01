package com.serglife.composition.ext

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.serglife.composition.R
import com.serglife.composition.domain.entity.GameResult


interface OnOptionClickListener{
    fun onOptionClick(option: Int)
}


// Adapters for fragment "fragment_game"

@BindingAdapter("numberAsText")
fun bindNumberASText(textV: TextView, number: Int){
    textV.text = number.toString()
}

@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar, flag:Boolean){
    progressBar.progressTintList = ColorStateList.valueOf(getColorByState(flag, progressBar.context))
}

@BindingAdapter("enoughCount")
fun bindEnoughCount(textV: TextView, flag: Boolean){
    textV.setTextColor(getColorByState(flag, textV.context))
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textV: TextView, clickListener: OnOptionClickListener){
    textV.setOnClickListener {
        clickListener.onOptionClick(textV.text.toString().toInt())
    }
}

// Adapters for fragment "fragment_game_finished"
@BindingAdapter("emojiResult")
fun bindEmojiResult(imageV: ImageView, flag: Boolean){
    imageV.setImageResource(if(flag) R.drawable.ic_smile else R.drawable.ic_sad)
}

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textV: TextView, count:Int){
    textV.text = String.format(
        textV.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textV: TextView, count: Int){
    textV.text = String.format(
        textV.context.getString(R.string.score_answers),
        count
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textV: TextView, count: Int){
    textV.text = String.format(
        textV.context.getString(R.string.required_percentage),
        count
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textV: TextView, result: GameResult){
    textV.text = String.format(
        textV.context.getString(R.string.score_percentage),
        if (result.countOfQuestions == 0) 0
        else ((result.countOfRightAnswers / result.countOfQuestions.toDouble()) * 100).toInt()
    )
}

private fun getColorByState(goodState: Boolean, context: Context): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}