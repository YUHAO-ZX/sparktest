package com.scala.st.Test

/**
  * Created by niceday on 17/5/4.
  */
object Chapter1 {
  def main(args: Array[String]): Unit = {
    //从控制行读入
//    terInput()

    //for (i <- 1 to 10)   含义：让i遍历右边表达式的所有值

    //多重循环，一个表达式,可以写过滤条件
    for(i <- 1 to 10;j<-2 to 5 if i != j){
      print(10*i+j+" ")
    }

    println

    //可定义变量
    for(i <- 1 to 3 ;from = 4-i;j<-from to 3){
      print(10*i+j+" ")
    }

    println

    //yield 返回集合  这种返回和第一个循环对象的类型是一致的，所以这里返回了集合
    var t = for(i <- 1 to 10) yield i % 3
    println(t)
    //这里就返回了字符串
    var m = for(c <- "dfdf";i <- 0 to 1)yield (c + i).toChar

    println(m)


    println(fac(5))

    println(decorate("ddd","(",")"))
    println(decorate("ddd"))
    println(decorate("ddd",right = ">>>")) //可以显示地指定某个参数地值

    println(sum(1,2,3,4,5))

    //每次引用words的时候都会去取一次
    def      words = scala.io.Source.fromFile("/Users/niceday/testdata/1.txt").mkString
    //只取一次
    val      words1 = scala.io.Source.fromFile("/Users/niceday/testdata/1.txt").mkString
    //当实际引用的时候取一次
    lazy val words2 = scala.io.Source.fromFile("/Users/niceday/testdata/1.txt").mkString

    println(words)
    println(words1)
    println(words2)

    //scala 没有编译期异常


  }

  def terInput(): Unit={
    var name = readLine("Your name:")
    println(name)
  }

  //阶乘计算
  def fac(n:Int):Int={
    if(n==0){
      1
    }else{
      n * fac(n - 1)
    }
  }

  //带默认参数的方法定义,不传入则走默认
  def decorate(str:String,left:String="[",right: String="]"):String={
    left+str+right
  }

  //多参数列表   同java 中的Integer...
  def sum(numbers:Int*):Int={
    var rs = 0
    for(arg <- numbers){
      rs += arg
    }
    rs
  }
}
