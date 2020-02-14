package com.example.changemoney.model

class CountryMoneyModel {

    var id: Int = 0
    var code_money_from :String = ""
    var description_money_from :String = ""
    var value_money_from :Double = 0.0
    var code_money_to :String = ""
    var description_money_to :String = ""
    var value_money_to :Double = 0.0

    constructor(){}


    constructor(id:Int , code_money_from :String  ,description_money_from :String ,value_money_from:Double ,
                code_money_to:String  ,description_money_to :String ,value_money_to:Double) {

        this.id = id
        this.code_money_from= code_money_from
        this.description_money_from = description_money_from
        this.value_money_from = value_money_from
        this.code_money_to = code_money_to
        this.description_money_to   = description_money_to
        this.value_money_to = value_money_to
    }

}