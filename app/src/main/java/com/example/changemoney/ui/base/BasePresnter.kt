package com.example.changemoney.ui.base

import com.example.changemoney.data.DataManager


class BasePresenter<V : IView>(dataManager: DataManager) :IPresenter<V> {

    private var mDataManager: DataManager = dataManager
    private var mMvpView: V? = null

    init  {
        mDataManager = dataManager
    }

    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    fun getMvpView(): V? {
        return mMvpView
    }

    fun getDataManager(): DataManager {
        return mDataManager
    }
}
