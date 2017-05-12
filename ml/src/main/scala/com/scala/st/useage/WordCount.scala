package com.scala.st.useage

import com.scala.st.common.Constants
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by niceday on 17/5/3.
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    var conf = new SparkConf().setMaster("local").setAppName("wordcount")

    var sc = new SparkContext(conf)
    var data = sc.textFile(Constants.getPath("wc.txt"))

    data.flatMap(_.split(" ")).map((_ , 1)).reduceByKey(_+_).collect().foreach(println)
  }
}
