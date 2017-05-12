package com.scala.st.Test

import scala.collection.mutable
import scala.io.Source

/**
  * Created by niceday on 17/5/4.
  */
object Chapter16 {
  def main(args: Array[String]): Unit = {
    var html = Source.fromURL("http://livest.jumei.com/show/views/manage.jsp#","UTF-8").mkString
    print(html)
    
  }
}
