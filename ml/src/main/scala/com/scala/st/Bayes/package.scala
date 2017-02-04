package com.scala.st

/**
 * Created by xinz on 2017/1/20.
 */
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object Bayes {
  def main(args: Array[String]) {

    val conf = new SparkConf()                                     //创建环境变量
      .setMaster("local")                                             //设置本地化处理
      .setAppName("Bayes ")                              			//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = MLUtils.loadLabeledPoints(sc,"E:\\testdata\\bayes.txt")			//读取数据集
    val model = NaiveBayes.train(data, 1.0)						//训练贝叶斯模型
    model.labels.foreach(println)								//打印label值
    model.pi.foreach(println)						    			//打印先验概率
    val test = Vectors.dense(0,0,1)
    var result = model.predict(test)
    println(result)
  }
}
