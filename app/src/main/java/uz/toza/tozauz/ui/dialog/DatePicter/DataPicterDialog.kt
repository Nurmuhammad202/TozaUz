package uz.toza.tozauz.ui.dialog.DatePicter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.ItemPrrofileDataDialogLayoutBinding
import uz.toza.tozauz.ui.dialog.BaseAlertDialog
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
class DataPicterDialog(context: Context, var type:String,var success: (String) -> Unit) :
    BaseAlertDialog(context) {
    private val binding = ItemPrrofileDataDialogLayoutBinding.inflate(LayoutInflater.from(context))

    init {
        setCancelable(false)
        //min date...
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR))
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH))
        binding.datePicker.maxDate = calendar.timeInMillis

        binding.apply {
            btClose.setOnClickListener {
                dismiss()
            }

            btnSave.setOnClickListener {
                val day: String = if (binding.datePicker.dayOfMonth < 10) {
                    "0${binding.datePicker.dayOfMonth}"
                } else {
                    binding.datePicker.dayOfMonth.toString()
                }
                success("${day}.${binding.datePicker.month}.${binding.datePicker.year}")
                dismiss()
            }
        }

        setView(binding.root)
    }


}