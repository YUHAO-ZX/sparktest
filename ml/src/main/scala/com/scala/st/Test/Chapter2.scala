package com.scala.st.Test

import scala.collection.mutable.ArrayBuffer

/**
  * Created by niceday on 17/5/4.
  */
object Chapter2 {
  def main(args: Array[String]): Unit = {
    fixArray()


    sort


  }
  //定长数组
  def fixArray(): Unit ={
    var array = new Array[String](10)
    var array1 = Array[String]("2","sdf")
    print(array1(1))
  }

  //变长数组的操作
  def varLenArray(): Unit ={
    val b = ArrayBuffer[Int]()
    b += 1

    b += (1, 2, 3, 5)

    b ++= Array(8, 13, 21)  //++=   集合添加

    b.trimEnd(5)

  }


  def sort(): Unit ={
    val b = ArrayBuffer(1,5,42,-9)
    val sorted = b.sortWith(_<_)//排序，并生成一个新的不可变数组

    sorted.foreach(print)

    val a = Array(1, 7, 2, 9)
    scala.util.Sorting.quickSort(a)//快排序，针对不可变数组，直接在目标数组上做操作

    println(a.mkString(","))//进行逗号分割
  }

  //多维数组
  def MultiDimensionalArray(): Unit ={
    val matrix = Array.ofDim[Double](3,4)   //三行四列

    matrix(0)(0) = 42

    //不规则的多维数组创建
    val triangle = new Array[Array[Int]](10)
    for (i <- 0 until triangle.length)
      triangle(i) = new Array[Int](i + 1)
  }



}
