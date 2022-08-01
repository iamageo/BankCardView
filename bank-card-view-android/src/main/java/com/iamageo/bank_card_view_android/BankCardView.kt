package com.iamageo.bank_card_view_android

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.bank_card_view.view.*

class BankCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    enum class CardLogo {
        VISA,
        MASTERCARD,
        AMERICAN_EXPRESS,
        CIELO
    }

    //cfd9df → #e2ebf0
    //Amy Crisp
    enum class CardBackground {
        HEAVY_RAIN,
        AMY_CHRISP,
        TRUE_SUNSET,

    }

    var bankCardName: String? = ""
        set(value) {
            field = value
            bank_card_view_name.text = field
        }

    var bankCardNumber: String? = ""
        set(value) {
            field = value
            bank_card_view_number.text = field
        }

    var bankCardValidate: String? = ""
        set(value) {
            field = value
            bank_card_view_validate_date.text = field
        }

    var bankCardCVV: String ? = ""
        set(value) {
            field = value
            bank_card_view_cvv.text = field
        }

    var bankCardLogo: CardLogo? = null
        set(value) {
            field = value
            when(value) {
                CardLogo.CIELO -> { bank_card_view_logo.setImageResource(R.drawable.ic_bank_card_view_cielo) }
                CardLogo.AMERICAN_EXPRESS -> { bank_card_view_logo.setImageResource(R.drawable.ic_bank_card_view_american_express) }
                CardLogo.VISA -> { bank_card_view_logo.setImageResource(R.drawable.ic_bank_card_view_visa) }
                CardLogo.MASTERCARD -> {bank_card_view_logo.setImageResource(R.drawable.ic_bank_card_view_mastercard) }
                else -> {  }
            }
        }

    var bankCardBackground: CardBackground? = null
        set(value){
            field = value
            when(value) {
                CardBackground.AMY_CHRISP -> { bank_card_view.background = ContextCompat.getDrawable(context, (R.drawable.bank_card_view_gradient_amy_chrisp)) }
                CardBackground.HEAVY_RAIN -> {  bank_card_view.background = ContextCompat.getDrawable(context, (R.drawable.bank_card_view_gradient_heavy_rain))  }
                CardBackground.TRUE_SUNSET -> {  bank_card_view.background = ContextCompat.getDrawable(context, (R.drawable.bank_card_view_gradient_true_sunset))  }
                else -> {}
            }
        }

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
        showCardContent(isBackCard = true)
        bank_card_view_number_reverse.text = bankCardNumber?.reversed()
    }

    private fun setupCardBankFront() {
        showCardContent(isBackCard = false)
    }

    private fun showCardContent(isBackCard: Boolean) {
        bankCardViewBack.visibility = if (isBackCard) View.VISIBLE else View.GONE
        bankCardViewFront.visibility = if (isBackCard) View.GONE else View.VISIBLE
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.bank_card_view, this, true)
        extractAttrs(attrs, defStyleAttr)
    }

    private fun extractAttrs(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        val array = context.theme.obtainStyledAttributes(attrs, R.styleable.BankCardView, defStyleAttr, 0)
        isFrontCard = array.getBoolean(R.styleable.BankCardView_isFrontCard, true)
        bankCardName = array.getString(R.styleable.BankCardView_bankCardName)
        bankCardNumber = array.getString(R.styleable.BankCardView_bankCardNumber)
        bankCardValidate = array.getString(R.styleable.BankCardView_bankCardValidate)
        bankCardCVV = array.getString(R.styleable.BankCardView_bankCardCVV)
    }
}
