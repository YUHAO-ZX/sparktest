package com.scala.st.Test


/**
  * Created by niceday on 17/5/4.
  */
object Chapter12 {
  def main(args: Array[String]): Unit = {
    import scala.math._
    var num = 3.14

    //ceil _ 表示将方法给到fun
    var fun = ceil _
    print(fun(num))

    //函数的参数为函数
    var array = Array(3.14,1.42,2.0).map(fun)
    array.foreach(println)


    //匿名函数
    var f = (param:Int) => 8 * param
    println(f(100))

    //map(函数)  (x:Double) => x * 100 提供一个匿名函数   也可以不用写参数类型：x => x * 100
    var array1 = Array(3.14,1.42,2.0).map(x => x * 100)
    array1.foreach(println)

    //如果x只出现一次，那么可以将x改写为_
    var array2 = Array(3.14,1.42,2.0).map(_ * 100)
    array2.foreach(println)


    //定义接收方法的函数
    def v1(fun:(Double) => Double) = {fun(0.25) * 5 - 1}
    println(v1(ceil))
    println(v1(sqrt))


    //接收两个参数的用法,几种不同的写法(都是基于匿名函数)
    var jiec = (1 to 10).reduceLeft(_ * _)
    println(jiec)

    var jiec1 = (1 to 10).reduceLeft((x,y) => x * y)
    println(jiec1)

    var jiec2 = (1 to 10).reduceLeft((x:Int,y:Int) => x * y)
    println(jiec2)

    var max1 = Array(2,5,23,99,32).reduceLeft(max(_,_))
    println("max="+max1)

    //接收无参数的方法，用于构建语法功能
    runThread{println("hi");Thread.sleep(1000);println("bye")}


    //实现自定义语法
    var x = 10
    until(x == 0){
      println(x)
      x -= 1
    }

    var pairs = (1 to 10) zip (11 to 20)

    println(pairs(1)._1)

  }




  //多个函数依次排列
  def until(condition: => Boolean)(block: => Unit): Unit ={
    if(!condition){
      block
      until(condition)(block)
    }
  }


  def runThread(block: => Unit): Unit ={
    new Thread{
      override def run(): Unit = {block}
    }.start()
  }

}
