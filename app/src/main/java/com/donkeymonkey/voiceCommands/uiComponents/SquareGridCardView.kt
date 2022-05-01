package com.donkeymonkey.voiceCommands.uiComponents

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView

class SquareGridCardView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    CardView(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context): this(context, null, 0)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}