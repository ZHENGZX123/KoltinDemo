package koltindem.koltindemo.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import koltindem.koltindemo.R
import kotlinx.android.synthetic.main.dialog_view.*

/**
 * Created by Administrator on 2017/6/5.
 */
class MyDialog(context: Context?, callbacks: dialogCallBack) : BaseDialog(context!!){

    var callbacks: dialogCallBack = callbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_view)
        fullWindowCenter(context)
        sure_button.setOnClickListener(this)
        cancle_button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            sure_button -> callbacks.dialogSure()
            cancle_button -> {
                callbacks.dialogCancle()
                dismiss()
            }
        }
    }

    interface dialogCallBack {
        fun dialogSure()
        fun dialogCancle()
    }
}