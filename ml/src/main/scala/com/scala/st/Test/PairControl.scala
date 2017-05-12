package com.scala.st.Test

/**
  * 向量计算
  * Created by niceday on 17/5/5.
  */
object PairControl extends App{
  var list = List[Int]()

  def mu(fun:(Int,Int) => Int,a1:Int,a2:Int)={
    list = fun(a1,a2) :: list
  }

  def map(fun:(Int,Int) => Int): Int ={
    list.reduceLeft(fun)
  }

  var pairs = (1 to 10) zip (11 to 20)

  for((a,b) <- pairs){
    mu(_*_,a,b)
  }
  println(map(_+_))
}
