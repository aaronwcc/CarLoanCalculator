package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            calculateRepayment();
        }


    }

    private fun calculateRepayment(){
        if(txtCarPrice.text.isEmpty()){
            txtCarPrice.setText(getString(R.string.error_input))
            return
        }

        val carPrice: Int= txtCarPrice.text.toString().toInt()
        val downPayment : Int = txtDownPayment.text.toString().toInt()
        val loan = carPrice - downPayment


        


        lblLoan.setText( + getString(R.string.loan) + "${loan}")
        val interestRate : Float = txtInterestRate.text.toString().toFloat()
        val loanPeriod : Int = txtLoanPeriod.text.toString().toInt()
        val interest = loan * interestRate/100 * loanPeriod

        lblInterest.setText(getString(R.string.interest) + "${interest}")

        val monthlyRepayment = (loan + interest) / loanPeriod / 12
        lblMr.setText(getString(R.string.monthy_repayment) + "${monthlyRepayment}")


    }

    fun reset(view: View){
        txtCarPrice.setText("")
        txtDownPayment.setText("")
        txtInterestRate.setText("")
        txtLoanPeriod.setText("")
        lblMr.setText(getString(R.string.interest))
        lblInterest.setText(getString(R.string.interest))
        lblLoan.setText(getString(R.string.loan))
    }
}
