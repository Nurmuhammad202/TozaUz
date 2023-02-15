package uz.toza.tozauz.ui.dialog.lang

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.ItemLangBinding
import uz.toza.tozauz.ui.dialog.BaseAlertDialog

class LangChangeDialog(context: Context, var changLang: (String) -> Unit) : BaseAlertDialog(context) {
    private val binding = ItemLangBinding.inflate(LayoutInflater.from(context))

    init {
        setCancelable(true)
        binding.apply {
            btnRu.setOnClickListener {
                changLang("ru")
                dismiss()
            }

            btnUzb.setOnClickListener {
                changLang("uz")
                dismiss()
            }
        }
        setView(binding.root)
    }
}