package com.scala.st.Test

/**
  * Created by niceday on 17/5/4.
  */
object Chapter5 {
  def main(args: Array[String]): Unit = {
    //scala 中 class是不能有静态方法和静态对象的，需要通过  object来实现
    //object 是单例的,方法和对象是静态的，故main函数能在object中执行
    val constructorTest = ConstructorTest("xinz",25)
     print(constructorTest.desc)
  }

}
