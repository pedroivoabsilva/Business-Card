package com.ivodev.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ivodev.businesscard.App
import com.ivodev.businesscard.R
import com.ivodev.businesscard.data.BusinessCard
import com.ivodev.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val biding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        insertListeners()
    }

    private fun insertListeners() {
        biding.btnClose.setOnClickListener {
            finish()
        }
        biding.fabSave.setOnClickListener {
            val businessCard = BusinessCard(
                nome = biding.tilName.editText?.text.toString(),
                empresa = biding.tilBusness.editText?.text.toString(),
                telefone = biding.tilPhone.editText?.text.toString(),
                email = biding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = biding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.lable_show_success,Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}