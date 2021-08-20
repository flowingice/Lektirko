package hr.tvz.mmisic.lektirko.ui.settings.font

import android.app.Activity
import android.content.Context
import hr.tvz.mmisic.lektirko.R

class FontUtil {

    companion object {
        fun getCurrentFontName(ctx: Context): String? {
            return ctx.getSharedPreferences(ctx.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
                .getString("font", "Arial")
        }

        fun saveFontToSettings(ctx: Context, value: String?) {
            val pref =
                ctx.getSharedPreferences(ctx.getString(R.string.preference_file_key), Context.MODE_PRIVATE).edit()
            pref.putString("font", value)
            pref.apply()
        }

        fun getFontByName(value: String?): Int {
            var fontType: Int = R.font.arial_regular;
            if (value.equals("Open Dyslexic 3")) {
                fontType = R.font.opendyslexic3_regular;
            } else if (value.equals("Arial")) {
                fontType = R.font.arial_regular;
            } else if (value.equals("Times New Roman")) {
                fontType = R.font.timesnewroman_regular;
            }
            return fontType;
        }

        private fun getThemeFromSettings(ctx: Context): Int {
            val font = getFontByName(getCurrentFontName(ctx))
            return if (font == R.font.opendyslexic3_regular)
                R.style.Theme_OpenDyslexic
            else if (font == R.font.arial_regular)
                R.style.Theme_Arial
            else if (font == R.font.timesnewroman_regular)
                R.style.Theme_TimesNewRoman
            else R.style.AppTheme
        }

        fun updateTheme(activity: Activity){
            activity.setTheme(getThemeFromSettings(activity.applicationContext))
        }
    }
}
