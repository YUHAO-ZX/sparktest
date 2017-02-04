package com.scala.st

/**
 * Created by xinz on 2017/1/20.
 */

import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object BayesTest {

  def main(args: Array[String]) {
    val conf = new SparkConf()                                     //创建环境变量
      .setMaster("local")                                             //设置本地化处理
      .setAppName("BayesTest ")                              			//设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例
    val data = MLUtils.loadLabeledPoints(sc,"E:\\testdata\\bayesTest.txt")			//读取数据集
    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L)			//对数据进行分配
    val trainingData = splits(0)									//设置训练数据
    val testData = splits(1)									//设置测试数据
    val model = NaiveBayes.train(trainingData, lambda = 1.0)			//训练贝叶斯模型
    val predictionAndLabel = testData.map(p => (model.predict(p.features), p.label)) //验证模型
    val accuracy = 1.0 * predictionAndLabel.filter(					//计算准确度
        label => label._1 == label._2).count()						//比较结果
    println(accuracy)										//打印准确度

    //org.apache.spark.SparkException: Naive Bayes requires nonnegative feature values but found [-2.0,-1.0,1.0].
  }
}
