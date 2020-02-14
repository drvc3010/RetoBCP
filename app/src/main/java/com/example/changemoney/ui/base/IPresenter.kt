package com.example.changemoney.ui.base

interface IPresenter<V : IView> {

    fun onAttach(mvpView: V)

}
