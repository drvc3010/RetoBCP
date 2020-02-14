package com.example.changemoney.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.changemoney.R
import com.example.changemoney.controller.CountryMoneyController
import com.example.changemoney.util.Constants
import  kotlinx.android.synthetic.main.money_change_activity.*


class CountryMoneyActivity : AppCompatActivity() {
  var countryMoneyControlller :CountryMoneyController = CountryMoneyController()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.money_change_activity)
         var countryMoneyActivity : CountryMoneyActivity = this
        countryMoneyControlller.context = this
        countryMoneyControlller.getModel(Constants.DEFAULT_MONEY_FROM,Constants.TYPE_MONEY_TO)
        countryMoneyControlller= CountryMoneyController(Constants.DEFAULT_MONEY_FROM,Constants.DEFAULT_MONEY_TO,countryMoneyActivity,this)

        init()

    }

    fun init() {
        countryMoneyControlller.setValuesTexBox()
    }

    fun  goToSelectMoney() {


    }

    fun setValues() {
        edtOne.setText(countryMoneyControlller.countryMoneyModel?.value_money_from.toString())
        edtTwo.setText(countryMoneyControlller.countryMoneyModel?.value_money_to.toString())
    }


}
