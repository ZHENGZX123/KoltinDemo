package koltindem.koltindemo.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup.LayoutParams
import koltindem.koltindemo.R
import koltindem.koltindemo.activity.BaseActivity


open class BaseDialog @JvmOverloads constructor(context: Context, style: Int = R.style.LoadingDialog) : Dialog(context, style), OnClickListener {
    var displayMetrics = DisplayMetrics()
    var view: View? = null
    protected var layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

    override fun onClick(v: View) {

    }

    protected fun fullWindowCenter(context: Context) {
        layoutParams = window!!.attributes
        val rect = Rect()
        val v = window!!.decorView
        v.getWindowVisibleDisplayFrame(rect)
    }

    protected fun fullWindowBottom(context: Context) {
        layoutParams = window!!.attributes
        val ba = context as BaseActivity
        val rect = Rect()
        val v = window!!.decorView
        v.getWindowVisibleDisplayFrame(rect)
        layoutParams.width = displayMetrics.widthPixels
        val window = window
        window!!.setGravity(Gravity.BOTTOM)
    }

    protected fun fullWindowTop(context: Context) {
        layoutParams = window!!.attributes
        val ba = context as BaseActivity
        val rect = Rect()
        val v = window!!.decorView
        v.getWindowVisibleDisplayFrame(rect)
        layoutParams.width = displayMetrics.widthPixels
        val window = window
        window!!.setGravity(Gravity.TOP)
    }

    protected fun fullWindowWH(context: Context) {
        layoutParams = window!!.attributes
        val ba = context as BaseActivity
        val rect = Rect()
        val v = window!!.decorView
        v.getWindowVisibleDisplayFrame(rect)
        layoutParams.width = displayMetrics.widthPixels
        layoutParams.height = displayMetrics.heightPixels
        val window = window
        window!!.setGravity(Gravity.BOTTOM)
    }
}
