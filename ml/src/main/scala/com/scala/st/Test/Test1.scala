package com.scala.st.Test

import scala.math._
import java.io.PrintWriter

import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

/**
  * Created by niceday on 17/3/3.
  */
object Test1 {
  def main(args: Array[String]): Unit = {
    //for 用法1
//    useFor()

//    mutiFor()

    //函数式编程范例
//    wtFunc()

    //函数式编程：函数的传递
//    delegate()

//    fileIo()

//    trycatch()

    test()
  }

  def test(): Unit ={
    //todo test 2
    var conf = new SparkConf().setMaster("local").setAppName("testRDDMethod")
    var sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1,2,3,4,5,5),3)//将array均分为两个数组，
    var result = arr.aggregate(0)(math.max(_,_),_+_)//将两个数组中最大值进行相加
    println(result)
  }

  def trycatch(): Unit ={
    try{
      0/0
    }catch {
      case ex : java.lang.Throwable => print("exception " + ex)
    }finally {
      throw new RuntimeException()
    }
  }
  def fileIo(): Unit ={
    var file = new PrintWriter("/Users/niceday/1.txt")
    file.write("something any way")
    file.close()

    var textFromFile = Source.fromFile("/Users/niceday/1.txt","UTF-8")
    var iterator = textFromFile.getLines()
    for(line <- iterator){
      print(line)
    }
    textFromFile.close()
  }

  def delegate(): Unit ={
    var num = 5
    var func = (param : Int) => param / num;

    print(func(400))

  }


  def wtFunc(): Unit ={
    val log10Func = log10 _

    //委托

    //通过函数处理数据
    List(100.0,1000.0,10000.0).map(log10Func).foreach(println)

    //对数据进行逻辑处理  匿名方法：(x:Int)   委托给：x*50   ｀委托｀
    List(1,2,3,4,5).map((x:Int) => x*50).foreach(println)

    //对数据进行过滤  _ 表示数据本身
    List(1,2,3,4,5).filter(_ % 2 == 0).foreach(println)
  }

  def mutiFor(): Unit ={
    var t = ("1","2",9.34);
    print(t._3)
  }

  def useFor(): Unit ={
    val num2 = for(num <- 0 to 100 if num % 10 == 0) yield num *2;
    num2.foreach(prin)
  }

  def prin(param:Int): Unit ={
    print(" "+param)
  }
}
