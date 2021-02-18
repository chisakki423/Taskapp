package jp.techacademy.chisaki.yoshioka.taskapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
//カスタムしたAdapter
// ListViewの各行のViewを返す部分を自分で記述
// 値を加工するなど任意のことを行うことができる
// 日付のデータを文字列に変換してViewに設定

class TaskAdapter(context: Context): BaseAdapter() {
    //レイアウトを動的に変更 ListViewの中に動的にxmlを差し込む
    private val mLayoutInflater: LayoutInflater
    //ArrayListの型をTaskクラスに変更 task.kt
    var mTaskList= mutableListOf<Task>()

    //初期化
    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    //データの数を返す
    override fun getCount(): Int {
        return mTaskList.size
    }

    //データを返す
    override fun getItem(position: Int): Any {
        return mTaskList[position]
    }

    //データのIDを返す
    override fun getItemId(position: Int): Long {
        return 0
    }

    //View(ボタンなどの部品)を返す
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: mLayoutInflater.inflate(android.R.layout.simple_list_item_2, null)

        val textView1 = view.findViewById<TextView>(android.R.id.text1)
        val textView2 = view.findViewById<TextView>(android.R.id.text2)

        // タスクのタイトルをTextViewに設定
        textView1.text = mTaskList[position].title

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE)
        val date = mTaskList[position].date
        // 時間をTextViewに設定
        textView2.text = simpleDateFormat.format(date)

        return view
    }
}