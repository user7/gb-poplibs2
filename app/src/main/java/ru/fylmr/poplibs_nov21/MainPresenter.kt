package ru.fylmr.poplibs_nov21

class MainPresenter(
    private val view: MainView
) {

    private val model = CountersModel()

    fun onCounter1Clicked() {
        val nextValue = model.increment1()
        view.setButton1Text(nextValue.toString())
    }

    fun onCounter2Clicked() {
        val nextValue = model.increment2()
        view.setButton2Text(nextValue.toString())
    }

    fun onCounter3Clicked() {
        val nextValue = model.increment3()
        view.setButton3Text(nextValue.toString())
    }
}