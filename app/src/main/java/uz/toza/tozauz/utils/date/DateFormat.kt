package uz.toza.tozauz.utils.date

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
inline fun dateConvert(dateFormatOutput: (String) -> Unit) {
    val dateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    dateFormatOutput(dateTime.format(formatter))
}