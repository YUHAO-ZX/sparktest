package com.scala.st.Test


/**
  * Created by niceday on 17/5/4.
  */
object Chapter13 {
  def main(args: Array[String]): Unit = {
    val names = Array("zhangxin","xxx","ttt")
    var result = names.map(ulcase)  //返回Vector数组
    var result1 = names.flatMap(ulcase)  //返回String[]
    print(result)
    print(result1)

    //collect 对感兴趣的字符做处理，放入到vector中
    var t = "-3+4".collect{case '+' => 1;case '-' => -1}
    print(t)

    //zip All 的缺省值
    List(1,2,3).zipAll(List(4,5),0,1).foreach(println)
  }


  def ulcase(s:String) = Vector(s.toUpperCase(),s.toLowerCase())

}
