package hr.tvz.mmisic.lektirko

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val currentDate = Calendar.getInstance()

        return DatePickerDialog(requireContext(), this, Calendar.getInstance().get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DAY_OF_MONTH))
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val realMonth = month+1
        Log.i("DatePickerFragment", "Set:$dayOfMonth $realMonth $year")
        val fragment = fragmentManager?.findFragmentByTag("AddReadingLogFragment") as DialogFragment
        val field = fragment.dialog?.findViewById(R.id.reading_date) as TextView
        field.text="$dayOfMonth.$realMonth.$year."

    }
}
