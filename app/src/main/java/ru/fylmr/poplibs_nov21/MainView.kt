package ru.fylmr.poplibs_nov21

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainView : MvpView {

    @AddToEndSingle
    fun setButton1Text(text: String)

    @AddToEndSingle
    fun setButton2Text(text: String)

    @AddToEndSingle
    fun setButton3Text(text: String)
}