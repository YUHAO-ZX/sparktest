package com.scala.st.Test

import scala.collection.mutable._
import scala.collection.mutable.ArrayBuffer

/**
  * Created by niceday on 17/5/4.
  */
object Chapter3 {
  def main(args: Array[String]): Unit = {
    tupleTest
  }

  def mapTest(): Unit ={

    //  `->`  这个操作符用于创建对偶  "ttt"->1  相当于  ("ttt",1)
    val immutableMap = Map("ttt"->1,"ddd"->2)//不可变

    val mutableMap = scala.collection.mutable.Map("ttt"->3,"ddd"->4) //可变

    val emptyMutableMap = new HashMap[String,Int]()

    //map 操作  详见官方文档



  }

  //元组
  def tupleTest(): Unit ={
    val tuple = ("zhangxin","english","150")
    println(tuple._1)//元组的访问

    //多纬度数据组合  ！！！！！！
    val symbol = Array("<","-",">")
    val counts = Array(2,10,2)
    val pairs  = symbol.zip(counts)

    for((s,n) <- pairs)print(s * n)



  }
}
