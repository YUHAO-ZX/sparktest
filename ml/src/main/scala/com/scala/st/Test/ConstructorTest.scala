package com.scala.st.Test

/**
  * private  表示外部不能直接调用构造方法
  * Created by niceday on 17/5/4.
  */
class ConstructorTest private (val name:String,val age:Int) {

  def desc(): String ={
    "name:"+name+" age:"+age
  }

}

object ConstructorTest{//伴生对象   可以互相访问私有对象
  private var wight:String = "65KG"
  private def desc() = {wight}

  def apply(name: String,age: Int) = new ConstructorTest(name,age)

  def main(args: Array[String]): Unit = {
    print(ConstructorTest("xinz",25).desc())
  }
}
