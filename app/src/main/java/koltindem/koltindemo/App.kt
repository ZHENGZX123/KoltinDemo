package koltindem.koltindemo

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/5/26.
 */

class App : Application() {

    var httpClient = OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
            .writeTimeout(30, TimeUnit.SECONDS)//设置写的超时时间
            .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
            .build()

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
