package com.scala.st.Test

import scala.collection.mutable

/**
  * Created by niceday on 17/5/4.
  */
object Chapter14 {
  def main(args: Array[String]): Unit = {

    //模式匹配
    println(getInteger(1))
    println(getInteger(19999999237482374L))
    println(getInteger("1234"))
    println(getInteger(new mutable.HashMap[String,String]()))

    println(matchArr(Array(1,0)))
    println(matchArr(Array(0,23,9)))
    println(matchArr(Array(1,3)))
    println(matchArr("some else"))

    println(matchList(List(0)))
    println(matchList(List(0,23,9)))
    println(matchList(List(1,3)))
    println(matchList("some else"))

    //模式匹配在for循环中的应用
    val map1 = Map(1->1,3->4)
    for((x,1) <- map1){
      print(x)
    }

    for((x,y) <- map1 if y == 1){
      print(x)
    }

    //copy
    

  }

  //类型匹配
  def getInteger(obj : Any): Int ={
    obj match {
      case x:Int => x
      case s:String => Integer.parseInt(s)
      case _:Long => Int.MaxValue
      case BigInt => Int.MaxValue
      case _ => 0
    }
  }

  def matchArr(obj : Any): String = {
    obj match {
      case Array(0) => "0"  //匹配包含0的数组
      case Array(x,y) => x + " " + y
      case Array(0,_*) => "0 ..."
      case _ => "something else"
    }
  }

  //匹配列表
  def matchList(obj : Any): String = {
    obj match {
      case 0 :: Nil => "0"
      case x :: y :: Nil => x +" " + y
      case 0 :: tail => "0 ..."
      case _ => "something else"
    }
  }
}
