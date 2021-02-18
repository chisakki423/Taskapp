package jp.techacademy.chisaki.yoshioka.taskapp

import java.io.Serializable
import java.util.Date
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

//serializable 別のactivityに渡すことができる
open class Task:RealmObject(),Serializable {
    var title:String=""//タイトル
    var contents:String=""//内容
    var date:Date=Date()//日時

    //idをプライマリーキーとして設定 Realmが判断するために必要
    @PrimaryKey
    var id:Int=0
    var category:String=""//カテゴリー
}