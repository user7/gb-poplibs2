package ru.fylmr.poplibs_nov21

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.fylmr.poplibs_nov21.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return MainPresenter(CountersModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter1.setOnClickListener {
            presenter.onCounter1Clicked()
        }
        binding.btnCounter2.setOnClickListener {
            presenter.onCounter2Clicked()
        }
        binding.btnCounter3.setOnClickListener {
            presenter.onCounter3Clicked()
        }
    }

    override fun setButton1Text(text: String) {
        binding.btnCounter1.text = text
    }

    override fun setButton2Text(text: String) {
        binding.btnCounter2.text = text
    }

    override fun setButton3Text(text: String) {
        binding.btnCounter3.text = text
    }
}