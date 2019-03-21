package jp.yama.mvvm001

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null
    private var txt1: TextView? = null
    private var txt2: TextView? = null
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.txt1 = findViewById(R.id.txtlbl1)
        this.txt2 = findViewById(R.id.txtlbl2)
        this.btn1 = findViewById(R.id.button1)
        this.btn2 = findViewById(R.id.button2)
        this.btn3 = findViewById(R.id.button3)
        this.viewModel = MainViewModel {
            when (it) {
                MainViewModelState.Lbl1ValueChanged -> {
                    this.txt1?.text = this.viewModel?.val1
                }
                MainViewModelState.Lbl2ValueChanged -> {
                    this.txt2?.text = this.viewModel?.val2.toString()
                }
            }
        }
        this.viewModel?.updateVal1("hogehoge")
        this.viewModel?.updateVal2()
        this.btn1?.setOnClickListener {
            this.viewModel?.updateVal1("hogehoge")
        }
        this.btn2?.setOnClickListener {
            this.viewModel?.updateVal1("fugafuga")
        }
        this.btn3?.setOnClickListener {
            this.viewModel?.updateVal2()
        }
    }

}
