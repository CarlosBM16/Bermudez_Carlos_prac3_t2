package com.example.ejercicio3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ejercicio1.R

class GameView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs){

    private val imageView : ImageView
    private val textView : TextView
    private val checkBox : CheckBox

    init {
        LayoutInflater.from(context).inflate(R.layout.game_view, this, true)
        orientation = HORIZONTAL
        imageView = findViewById(R.id.itemImg)
        textView = findViewById(R.id.itemText)
        checkBox = findViewById(R.id.itemCheck)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.GameView, 0, 0)

            val imgRes = typedArray.getResourceId(R.styleable.GameView_gameImg, -1)
            if (imgRes != -1) imageView.setImageResource(imgRes)

            val text = typedArray.getString(R.styleable.GameView_gameText) ?: ""
            textView.text = text

            val checked = typedArray.getBoolean(R.styleable.GameView_gameChecked, false)
            checkBox.isChecked = checked

            typedArray.recycle()
        }
    }

    fun setImage(resId : Int) {
        imageView.setImageResource(resId)
    }

    fun setText(text : String) {
        textView.text = text
    }

    fun setChecked(value : Boolean) {
        checkBox.isChecked = value
    }

    fun isChecked() : Boolean {
        return checkBox.isChecked
    }

    fun getText() : String {
        return textView.text.toString()
    }

}