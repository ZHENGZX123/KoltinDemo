package koltindem.koltindemo.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnDismissListener
import koltindem.koltindemo.R
import kotlinx.android.synthetic.main.login_dialog.*


class LoginDialog @SuppressLint("InflateParams")
constructor(internal var context: Context) : BaseDialog(context, R.style.loading_dialog), OnDismissListener {

    init {
        setContentView(R.layout.login_dialog)
        fullWindowCenter(context)
        loading_text.text = getContext().getText(R.string.login)
        setOnDismissListener(this)
    }

    fun setTitle(string: String) {
        loading_text.text = string
    }

    fun showDialog() {
        show()
        lv_circularring.startAnim()
    }

    fun closeDialog() {
        dismiss()
        lv_circularring.stopAnim()
    }

    override fun onDismiss(dialog: DialogInterface) {
        lv_circularring.stopAnim()
        dismiss()
    }
}
