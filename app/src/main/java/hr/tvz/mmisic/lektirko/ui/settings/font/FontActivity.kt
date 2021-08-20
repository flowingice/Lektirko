package hr.tvz.mmisic.lektirko.ui.settings.font

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import hr.tvz.mmisic.lektirko.R
import kotlinx.android.synthetic.main.activity_font.btn_save_font
import kotlinx.android.synthetic.main.activity_font.fontGroup
import kotlinx.android.synthetic.main.activity_font.textView_quick_fox

class FontActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FontUtil.updateTheme(this)
        setContentView(R.layout.activity_font)

        fontGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            textView_quick_fox.typeface = ResourcesCompat.getFont(this, FontUtil.getFontByName(radio.text as String?));
        }

        btn_save_font.setOnClickListener {
           FontUtil.saveFontToSettings(applicationContext, findViewById<RadioButton>(fontGroup.checkedRadioButtonId).text as String?)
            Toast.makeText(applicationContext, R.string.saved, Toast.LENGTH_SHORT).show()
        }
    }
}
