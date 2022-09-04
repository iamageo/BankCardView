package com.iamageo.bank_card_view_android

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.iamageo.bank_card_view_android.databinding.BankCardViewBinding

class BankCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding: BankCardViewBinding =
        BankCardViewBinding.inflate(LayoutInflater.from(context))

    enum class CardLogo {
        VISA,
        MASTERCARD,
        AMERICAN_EXPRESS,
        CIELO
    }

    enum class CardBackground {
        RIPE_MALINKA,
        AMY_CHRISP,
        TRUE_SUNSET,
        PURPLE_DIVISION
    }

    var bankCardName: String? = ""
        set(value) {
            field = value
            binding.bankCardViewName.text = field
        }

    var bankCardValidate: String? = ""
        set(value) {
            field = value
            binding.bankCardViewValidateDate.text = field
        }

    var bankCardCVV: String? = ""
        set(value) {
            field = value
            binding.bankCardViewCvv.text = field
        }

    var bankCardLogo: CardLogo? = null
        set(value) {
            field = value
            when (value) {
                CardLogo.CIELO -> {
                    binding.bankCardViewLogo.setImageResource(R.drawable.ic_bank_card_view_cielo)
                }
                CardLogo.AMERICAN_EXPRESS -> {
                    binding.bankCardViewLogo.setImageResource(R.drawable.ic_bank_card_view_american_express)
                }
                CardLogo.VISA -> {
                    binding.bankCardViewLogo.setImageResource(R.drawable.ic_bank_card_view_visa)
                }
                CardLogo.MASTERCARD -> {
                    binding.bankCardViewLogo.setImageResource(R.drawable.ic_bank_card_view_mastercard)
                }
                else -> {}
            }
        }

    var bankCardBackground: CardBackground? = null
        set(value) {
            field = value
            when (value) {
                CardBackground.AMY_CHRISP -> {
                    binding.bankCardView.background = ContextCompat.getDrawable(
                        context,
                        (R.drawable.bank_card_view_gradient_amy_chrisp)
                    )
                }
                CardBackground.RIPE_MALINKA -> {
                    binding.bankCardView.background = ContextCompat.getDrawable(
                        context,
                        (R.drawable.bank_card_view_gradient_ripe_malinka)
                    )
                }
                CardBackground.TRUE_SUNSET -> {
                    binding.bankCardView.background = ContextCompat.getDrawable(
                        context,
                        (R.drawable.bank_card_view_gradient_true_sunset)
                    )
                }
                CardBackground.PURPLE_DIVISION -> {
                    binding.bankCardView.background = ContextCompat.getDrawable(
                        context,
                        (R.drawable.bank_card_view_gradient_purple_division)
                    )
                }
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
    }

    private fun setupCardBankFront() {
        showCardContent(isBackCard = false)
    }

    private fun showCardContent(isBackCard: Boolean) {
        binding.bankCardViewBack.visibility = if (isBackCard) View.VISIBLE else View.GONE
        binding.bankCardViewFront.visibility = if (isBackCard) View.GONE else View.VISIBLE
    }

    init {
        addView(binding.root)
        extractAttrs(attrs, defStyleAttr)
    }

    private fun extractAttrs(attrs: AttributeSet?, defStyleAttr: Int = 0) {
        val array =
            context.theme.obtainStyledAttributes(attrs, R.styleable.BankCardView, defStyleAttr, 0)
        isFrontCard = array.getBoolean(R.styleable.BankCardView_isFrontCard, true)
        bankCardName = array.getString(R.styleable.BankCardView_bankCardName)
        //bankCardNumber = array.getString(R.styleable.BankCardView_bankCardNumber)
        bankCardValidate = array.getString(R.styleable.BankCardView_bankCardValidate)
        bankCardCVV = array.getString(R.styleable.BankCardView_bankCardCVV)
    }
}
