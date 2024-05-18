package com.example.kalkulatortip

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextBiayaLayanan: EditText
    private lateinit var radioGroupPilihanTip: RadioGroup
    private lateinit var saklarPembulatan: Switch
    private lateinit var tombolHitung: Button
    private lateinit var textViewHasilTip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextBiayaLayanan = findViewById(R.id.biaya_layanan)
        radioGroupPilihanTip = findViewById(R.id.pilihan_tip)
        saklarPembulatan = findViewById(R.id.saklar_pembulatan)
        tombolHitung = findViewById(R.id.tombol_hitung)
        textViewHasilTip = findViewById(R.id.hasil_tip)

        textViewHasilTip.text = getString(R.string.jumlah_tip_default)

        tombolHitung.setOnClickListener {
            hitungTip()
        }
    }

    private fun hitungTip() {
        val biayaLayanan = editTextBiayaLayanan.text.toString().toDoubleOrNull()
        if (biayaLayanan == null || biayaLayanan <= 0) {
            textViewHasilTip.text = getString(R.string.invalid_input)
            return
        }

        val persentaseTipTerpilih = when (radioGroupPilihanTip.checkedRadioButtonId) {
            R.id.pilihan_dua_puluh_persen -> 0.20
            R.id.pilihan_delapan_belas_persen -> 0.18
            R.id.pilihan_lima_belas_persen -> 0.15
            else -> 0.15
        }

        var jumlahTip = biayaLayanan * persentaseTipTerpilih
        if (saklarPembulatan.isChecked) {
            jumlahTip = kotlin.math.ceil(jumlahTip)
        }

        val tipFormat = String.format("%.2f", jumlahTip)
        textViewHasilTip.text = getString(R.string.jumlah_tip, tipFormat)
    }
}