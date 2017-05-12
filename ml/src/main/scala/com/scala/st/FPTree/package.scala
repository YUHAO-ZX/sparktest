package com.scala.st

/**
  * Created by niceday on 17/2/4.
  */
import com.scala.st.common.Constants
import org.apache.spark.mllib.fpm.FPGrowth
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
object FPTree {

  def main(args: Array[String]) {
    val conf = new SparkConf()                                     //创建环境变量
          .setMaster("local")                                             //设置本地化处理
          .setAppName("FPTree ")                              		//设定名称
    val sc = new SparkContext(conf)
    val data = sc.textFile(Constants.getPath("Fptree.txt"))

    val transactions: RDD[Array[String]] = data.map(s => s.trim.split(' '))

    val fpg = new FPGrowth()
      .setMinSupport(0.3)
      .setNumPartitions(10)
    val model = fpg.run(transactions)

//    model.freqItemsets.collect().foreach { itemset =>
//      println(itemset.items.mkString("[", ",", "]") + ", " + itemset.freq)
//    }
//
//    val minConfidence = 0.8
//    model.generateAssociationRules(minConfidence).collect().foreach { rule =>
//      println(
//        rule.antecedent.mkString("[", ",", "]")
//          + " => " + rule.consequent .mkString("[", ",", "]")
//          + ", " + rule.confidence)
//    }

//    val conf = new SparkConf()                                     //创建环境变量
//      .setMaster("local")                                             //设置本地化处理
//      .setAppName("FPTree ")                              		//设定名称
//    val sc = new SparkContext(conf)                                 //创建环境变量实例
//    val data = sc.textFile("/Users/niceday/testdata/Fptree.txt")								//读取数据
//    val fpg = new FPGrowth().setMinSupport(0.3)			//创建FP数实例并设置最小支持度
//    val model = fpg.run(data.map(s => s.trim.split(' ')))									//创建模型

  }
}