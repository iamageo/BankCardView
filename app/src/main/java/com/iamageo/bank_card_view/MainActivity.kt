package com.iamageo.bank_card_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iamageo.bank_card_view.databinding.ActivityMainBinding
import com.iamageo.bank_card_view_android.BankCardView
import com.iamageo.bank_card_view_android.FlipBankCardViewAnimation
import com.iamageo.bank_card_view_android.startAnimation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val animation: FlipBankCardViewAnimation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toolbar.setTitle("Personalização de cartão")
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)

        setupCardViewData()
        setupBankCardColors()
        setupBankCardClick()
    }

    private fun setupCardViewData() {
        binding.myBankCardView.bankCardName = "Jhon Doe"
        binding.myBankCardView.bankCardNumber = "0001 0002 0003 0004"
        binding.myBankCardView.bankCardValidate = "02/27"
        binding.myBankCardView.bankCardCVV = "007"
        binding.myBankCardView.bankCardLogo = BankCardView.CardLogo.MASTERCARD
        binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.RIPE_MALINKA
    }

    private fun setupBankCardColors() {
        binding.imvAmyChrisp.setOnClickListener {
            binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.AMY_CHRISP
        }

        binding.imvPurpleDivision.setOnClickListener {
            binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.PURPLE_DIVISION
        }

        binding.imvRipeMalinka.setOnClickListener {
            binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.RIPE_MALINKA
        }

        binding.imvTrueSunset.setOnClickListener {
            binding.myBankCardView.bankCardBackground = BankCardView.CardBackground.TRUE_SUNSET
        }
    }

    private fun setupBankCardClick() {
        binding.myBankCardView.setOnClickListener {
            startAnimation(animation, binding.myBankCardView, binding.myBankCardView, 180)
        }
    }
}