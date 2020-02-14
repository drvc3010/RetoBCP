package com.example.changemoney.ui.main

import com.example.changemoney.ui.base.IPresenter

interface MainPresenter<V : MainView>: IPresenter<V> {
    val emailId:String
    fun setUserLoggedOut()
}