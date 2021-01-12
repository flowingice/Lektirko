package hr.tvz.mmisic.lektirko

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BookReadingLogAdapter(
    private val context: Context,
    private val dataSource: ArrayList<LogItem>
) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.adapter_book_reading_log_entry_layout, parent, false)

        val date = rowView.findViewById(R.id.reading_date) as TextView
        val duration = rowView.findViewById(R.id.reading_duration) as TextView
        val noOfPages = rowView.findViewById(R.id.reading_no_pages) as TextView

        val currentLog = getItem(position) as LogItem
        date.text = currentLog.readingDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy."))
        duration.text = DecimalFormat("###.#").format(currentLog.readingDuration)
        noOfPages.text = currentLog.readingNoOfPages.toString()

        return rowView
    }

}
