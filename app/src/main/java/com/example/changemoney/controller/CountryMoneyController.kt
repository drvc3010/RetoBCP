package com.example.changemoney.controller

import android.content.Context
import com.example.changemoney.data.DataManager
import com.example.changemoney.model.CountryMoneyModel
import com.example.changemoney.ui.CountryMoneyActivity

class CountryMoneyController {
    var countryMoneyModel : CountryMoneyModel ? = null
    var countryMoneyActivity : CountryMoneyActivity ? = null
    lateinit var context:Context

    constructor()
    constructor(countryMoneyModel : CountryMoneyModel ? ,  countryMoneyActivity : CountryMoneyActivity ? ,context:Context  ){
        this.countryMoneyModel = countryMoneyModel
        this.countryMoneyActivity = countryMoneyActivity
        this.context = context
    }

    constructor(codeFrom:String , codeTo:String , countryMoneyActivity : CountryMoneyActivity ? ,context:Context  ){
        // this.countryMoneyModel = getModel(codeFrom,codeTo)
        this.countryMoneyActivity = countryMoneyActivity
        this.context = context
    }

    fun getModel(codeFrom:String , codeTo:String ) : CountryMoneyModel{
        var dataManager = DataManager()
        return dataManager.getModelByCodes(context,codeFrom,codeTo)
    }
    fun getValueMoneyFrom():Double{
        var valueMoney : Double = 0.0
        countryMoneyModel?.let {
            valueMoney = it.value_money_from
        }
        return  valueMoney
    }



    fun  goSelectMoneyView()  {
        countryMoneyActivity?.goToSelectMoney()
    }

    fun setValuesTexBox() {
        countryMoneyActivity?.setValues()
    }
}