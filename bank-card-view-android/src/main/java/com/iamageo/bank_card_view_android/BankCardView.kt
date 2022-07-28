package com.iamageo.bank_card_view_android

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.iamageo.bank_card_view_android.databinding.BankCardViewBinding

class BankCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?= null,
    defStyleAttr: Int = 0
): LinearLayout(context, attrs, defStyleAttr) {

    private val binding = BankCardViewBinding.inflate(LayoutInflater.from(context), this, true)

    var isFrontCard: Boolean = false
        set(value) {
            field = value
            if (value) {
                setupCardBankFront()
            } else {
                setupCardBankBack()
            }
        }


    private fun setupCardBankBack() {
        binding.tv.text = Resources.getSystem().getString(R.string.bank_card_cvv)
        binding.tvPrice.text = "Valid: 09/24"
    }

    private fun setupCardBankFront() {
        binding.tv.text ="Geovani Amaral"
        binding.tvPrice.text = "***-123-***-00"
    }


    init {
        LayoutInflater.from(context).inflate(R.layout.bank_card_view, this, true)
        extractAttrs(attrs, defStyleAttr)
    }

    private fun extractAttrs(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        val array = context.theme.obtainStyledAttributes(attrs, R.styleable.BankCardView, defStyleAttr, 0)
        isFrontCard = array.getBoolean(R.styleable.BankCardView_isFrontCard, true)
    }
}
