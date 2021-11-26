package ru.fylmr.poplibs_nov21

import moxy.MvpPresenter

class MainPresenter(
    private val model: CountersModel
) : MvpPresenter<MainView>() {

    fun onCounter1Clicked() {
        val nextValue = model.increment1()
        viewState.setButton1Text(nextValue.toString())
    }

    fun onCounter2Clicked() {
        val nextValue = model.increment2()
        viewState.setButton2Text(nextValue.toString())
    }

    fun onCounter3Clicked() {
        val nextValue = model.increment3()
        viewState.setButton3Text(nextValue.toString())
    }
}