package com.scala.st.Test

/**
  * Created by niceday on 17/5/5.
  */
class Unapply(name:String) {

}

object Unapply{
  def main(args: Array[String]): Unit = {
    val name1 = "zhang xin"

    val Unapply(first,last) = name1

    print(first)

    print(last)
  }

  //对象之间的转换定义
  def unapply(arg: String) ={
    var firstName = arg.split(" ")(0)
    var lastName = arg.split(" ")(1)
    Some(firstName,lastName)
  }


  def unapply(arg: Int) ={

  }
}
