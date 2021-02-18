package jp.techacademy.chisaki.yoshioka.taskapp

import android.app.Application
import io.realm.Realm
//モデルクラスと接続するRealmデータベースの準備
class TaskApp:Application() {
    override fun onCreate(){
        super.onCreate()
        Realm.init(this)//Realmを初期化
    }
}