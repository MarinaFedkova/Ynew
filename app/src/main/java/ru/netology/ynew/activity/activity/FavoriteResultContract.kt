package ru.netology.ynew.activity.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ru.netology.ynew.activity.dto.Stock

class FavoriteResultContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String?): Intent =
        Intent(context, FavoriteActivity::class.java)
            .setAction(Intent.ACTION_VIEW)


    override fun parseResult(resultCode: Int, intent: Intent?): String? =
        if (resultCode == Activity.RESULT_OK) {
            intent?.getParcelableExtra(Intent.EXTRA_DATA_REMOVED)
        } else {
            null
        }
}

