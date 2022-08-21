package com.iamageo.bank_card_view_android

fun GetCreditCardType(CreditCardNumber: String?): BankCardView.CardLogo {

    val regVisa = Regex("^4[0-9]{12}(?:[0-9]{3})?$")
    val regMaster = Regex("^5[1-5][0-9]{14}$")
    val regExpress = Regex("^3[47][0-9]{13}$")

    return if (regVisa.containsMatchIn(CreditCardNumber.toString()))
        BankCardView.CardLogo.VISA
    else if (regMaster.containsMatchIn(CreditCardNumber.toString()))
        BankCardView.CardLogo.MASTERCARD
    else if (regExpress.containsMatchIn(CreditCardNumber.toString()))
        BankCardView.CardLogo.AMERICAN_EXPRESS
    else
        BankCardView.CardLogo.CIELO
}