package com.scala.practice

import java.io.{File, PrintWriter}
import java.text.SimpleDateFormat
import java.util.Date

import sys.process._
import com.scala.st.common.Constants
import org.apache.spark.mllib.classification.{LogisticRegressionModel, LogisticRegressionWithLBFGS, LogisticRegressionWithSGD}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by niceday on 17/5/9.
  */
class Lris {
    										//打印结果

}
object Lris extends App{

  /*
  分类算法来预测多分类
   */
  var conf = new SparkConf().setMaster("local").setAppName("lris")
  var sc = new SparkContext(conf)
  val writer = new PrintWriter(new File("/Users/niceday/ml/irisSvm.data"))
  var data1 = sc.textFile("/Users/niceday/ml/iris.data")
  data1.foreach(toSVMFile(_))
  writer.close()


  val data = MLUtils.loadLibSVMFile(sc, "/Users/niceday/ml/irisSvm.data")

  val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
  val training = splits(0).cache()
  val test = splits(1)

  // Run training algorithm to build the model
  val model = new LogisticRegressionWithLBFGS()
    .setNumClasses(3)
    .run(training)

  // Compute raw scores on the test set.
  val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
    val prediction = model.predict(features)
    (prediction, label)
  }

  // Get evaluation metrics.
  val metrics = new MulticlassMetrics(predictionAndLabels)
  val precision = metrics.precision
  println("Precision = " + precision)

  // Save and load model
  val path = "/Users/niceday/ml/irisresult"
  model.save(sc, path) //保存模型

  //从文件系统重新加载模型，用于下次计算
  val sameModel = LogisticRegressionModel.load(sc, path)
  sc.stop


  def toType(name : String): Double ={
      case "Iris-setosa" => 0.0
      case "Iris-versicolor" => 1.0
      case "Iris-virginica" => 2.0
  }

  def toSVMFile(line :String): Unit ={
    var dt = line.split(",")
    var ty = toType(dt(4))
    var t = (ty+" 1:"+dt(0)+" 2:"+dt(1)+" 3:"+dt(2)+" 4:"+dt(3)+"\n")
    writer.append(t)
  }
}