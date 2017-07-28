package koltindem.koltindemo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import koltindem.koltindemo.R
import koltindem.koltindemo.dialog.LoginDialog
import koltindem.koltindemo.dialog.MyDialog
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : BaseActivity(), View.OnClickListener, MyDialog.dialogCallBack {

    var loginDialog: LoginDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        loginDialog = LoginDialog(this)
        cetent_dialog.setOnClickListener(this)
        login_dialog.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            cetent_dialog -> MyDialog(this, this).show()
            login_dialog -> loginDialog!!.showDialog()
        }
    }

    override fun dialogSure() {
        Toast.makeText(this, "我点击了确定,然后回调了", Toast.LENGTH_SHORT).show()
    }

    override fun dialogCancle() {
        Toast.makeText(this, "我点击了取消，然后回调了", Toast.LENGTH_SHORT).show()
    }
}
