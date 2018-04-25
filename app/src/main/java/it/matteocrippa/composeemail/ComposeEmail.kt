package it.matteocrippa.composeemail

import android.content.Context
import android.content.Intent
import android.net.Uri

class ComposeEmail private constructor() {

    // singleton
    private object Holder {
        val INSTANCE = ComposeEmail()
    }

    companion object {
        val shared: ComposeEmail by lazy { Holder.INSTANCE }
    }

    // init class
    init {
    }

    var context: Context? = null

    fun send(to: ArrayList<String>, subject: String, message: String, attachments: ArrayList<Uri>? = null, intentMessage: String = "") {

        val i = Intent(Intent.ACTION_SEND)
        i.type = "*/*"

        //add attachmensts
        attachments?.let {
            it.forEach {
                i.putExtra(Intent.EXTRA_STREAM, it)
            }
        }

        i.putExtra(Intent.EXTRA_EMAIL, to)
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        i.putExtra(Intent.EXTRA_TEXT, message)

        context?.startActivity(Intent.createChooser(i, intentMessage))
    }
}