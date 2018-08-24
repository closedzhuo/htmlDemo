package com.bonnidee.htmldemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // 网上加载的 数据
    var netString = "&lt;p&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/938895458116268325542800_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/376971680565580798687400_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/790106621142642705711030_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/487847932958638125141000_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/114296889713304561813038_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/146324807699599842178000_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/349873411156683004513400_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/107489173511150852380240_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/181480188214831031266206_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/417800177113422536646430_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/264456586171287706483460_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/188441258110420208757984_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/111414050414008857656890_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/120366806832711673169310_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/181239963836955596272210_x.jpg&quot;/&gt;&lt;img src=&quot;https://image.suning.cn/uimg/sop/commodity/117629241683374892955750_x.jpg&quot;/&gt;&lt;/p&gt;"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener(this)
        var settings = webview.settings
        settings.setJavaScriptEnabled(true)
        settings.setAppCacheEnabled(false)
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE)
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN)
        settings.setDefaultTextEncodingName("uft-8")
        settings.setLoadWithOverviewMode(true)
        settings.setUseWideViewPort(true)
        settings.setDomStorageEnabled(true)
    }


    //点击事件
    override fun onClick(v: View?) {
        // 解析成 html 标签
        var htmlString = Html.fromHtml(netString)
         // 给 图片设置宽高
        htmlString.toString().replace("<img", "<img height=\"auto\"; width=\"100%\"")
        webview.loadData(htmlString.toString(),"text/html",null)

    }

}
