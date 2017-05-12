package com.scala.st.Test
import scala.math._

/**
  * Created by niceday on 17/5/4.
  */
object Language {
  def main(args: Array[String]): Unit = {
    //test 1
    var a = 1;
    println("a.+(1)="+a.+(1)) //a.+(1) 函数写法  相当于a ＋ 1

    //test2    a.方法名(参数)   可改写为   a 方法名  参数
    println(a toString)

    //test3 scala.math._
    println(min(1,3))
    println(pow(3,3))
    println(sqrt(3))

    //test4 字符串去重  如果方法没有参数  可以不带括号
    println("Hello".distinct)

    //访问数组某位置字符   是"Hello".apply(4)的缩写
    println("Hello"(4))
    println("Hello".apply(4))

    //字符串翻倍
    println( "crazy" * 3 )


    //scala没有switch

    //表达式过长，需要将操作符放到最后，否则编译器无法识别
    var s = 1 + 2 +
    3
    println(s)

  }


}
