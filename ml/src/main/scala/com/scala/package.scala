package com
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.{Matrices, Vectors}
import org.apache.spark.mllib.stat.Statistics
/**
 * Created by xinz on 2017/1/17.
 */
package object scala {
  def myFilter(num: Int): Unit = {								   //自定义方法
    num >= 3                                                        //条件
  }
  def myFilter2(num: Int): Unit = {								   //自定义方法
    num < 3                                                         //条件
  }
  def myFun(str1:String,str2:String):String = {                          //创建方法
  var str = str1                                                   //设置确定方法
    if(str2.size >= str.size){                                          //比较长度
      str = str2                                                    //替换
    }
    return str                                                     //返回最长的那个字符串
  }

  def main(args: Array[String]) {
    val vd = Vectors.dense(1,1,1,1,2)                                 //
    val vdResult = Statistics.chiSqTest(vd)
    println(vdResult)
    println("-------------------------------")
    val mtx = Matrices.dense(3, 2, Array(1, 1, 1, 1, 1, 2))
    val mtxResult = Statistics.chiSqTest(mtx)
    println(mtxResult)
//todo
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("testSingleCorrect2 ")                                //设定名称
//    val sc = new SparkContext(conf)                                  //创建环境变量实例
//    val data = sc.textFile("E:\\testdata\\4.txt")                                   //读取数据
//        .map(row => {                                                //开始处理
//        if(row.length == 3)                                            //判断字符数
//          (row,1)                                                    //建立对应map
//        else (row,2)                                                  //建立对应map
//      })
//    val fractions: Map[String, Double] = Map("aa" -> 2)                 //设定抽样格式
//    val approxSample = data.sampleByKey(withReplacement = false, fractions,0) //计算抽样样本
//    approxSample.foreach(println)

//    //todo test 21  相关性  两两相关
//      val conf = new SparkConf()                                       //创建环境变量
//        .setMaster("local")                                               //设置本地化处理
//        .setAppName("testSingleCorrect ")                                //设定名称
//      val sc = new SparkContext(conf)                                  //创建环境变量实例
//      val rdd = sc.textFile("E:\\testdata\\3.txt")                                    //读取数据文件
//          .map(_.split(' ')                                               //切割数据
//          .map(_.toDouble))                                            //转化为Double类型
//          .map(line => Vectors.dense(line))                               //转为向量
//      println(Statistics.corr(rdd,"spearman"))
    //todo test 20  相关性   斯皮尔曼算法
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("testCorrect2 ")                                    //设定名称
//    val sc = new SparkContext(conf)                                  //创建环境变量实例
//    val rddX = sc.textFile("E:\\testdata\\1.txt")                                   //读取数据
//        .flatMap(_.split(' ')                                           //进行分割
//        .map(_.toDouble))                                           //转化为Double类型
//    val rddY = sc.textFile("E:\\testdata\\2.txt")                                   //读取数据
//        .flatMap(_.split(' ')                                             //进行分割
//        .map(_.toDouble))                                            //转化为Double类型
//    val correlation: Double = Statistics.corr(rddX, rddY,"spearman")    //使用斯皮尔曼计算不同数据之间的相关系数
//    println(correlation)
    //todo test 19   相关性   威尔逊算法
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("testCorrect ")                                    //设定名称
//    val sc = new SparkContext(conf)                                  //创建环境变量实例
//    val rddX = sc.textFile("E:\\testdata\\1.txt")                                   //读取数据
//        .flatMap(_.split(' ')                                           //进行分割
//        .map(_.toDouble))                                           //转化为Double类型
//    val rddY = sc.textFile("E:\\testdata\\2.txt")                                   //读取数据
//        .flatMap(_.split(' ')                                             //进行分割
//        .map(_.toDouble))                                            //转化为Double类型
//    val correlation: Double = Statistics.corr(rddX, rddY)                 //计算不同数据之间的相关系数
//    println(correlation)
    //todo test 18
//    val conf = new SparkConf()                                        //创建环境变量
//      .setMaster("local")                                                //设置本地化处理
//      .setAppName("testZip")                                       //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    val arr1 = Array(1,2,3,4,5,6)							       //创建数据集1
//    val arr2 = Array("a","b","c","d","e","f")                                //创建数据集1
//    val arr3 = Array("g","h","i","j","k","l")                                 //创建数据集1
//    val arr4 = arr1.zip(arr2).zip(arr3)                                   //进行亚述算法
//    arr4.foreach(print)
    //rs ((1,a),g)((2,b),h)((3,c),i)((4,d),j)((5,e),k)((6,f),l)
    //todo test 17
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                                //设置本地化处理
//      .setAppName("sortBy ")                                       //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var str = sc.parallelize(Array((5,"b"),(6,"a"),(1,"f"),(3,"d"),(4,"c"),(2,"e")))  //创建数据集
//    str = str.sortBy(word => word._1,true)                              //按第一个数据排序
//    val str2 = str.sortBy(word => word._2,true)                          //按第二个数据排序
//    str.foreach(print)                                                //打印输出结果
//    str2.foreach(print)
    //rs (1,f)(2,e)(3,d)(4,c)(5,b)(6,a)          (6,a)(5,b)(4,c)(3,d)(2,e)(1,f)
    //todo test 16
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("testRDDMethod ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var str = sc.parallelize(Array("one","two","three","four","five"))          //创建数据集
//    val result = str.reduce(myFun)								  //进行数据拟合
//    result.foreach(print)
    //todo test 15
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("testReduce ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var str = sc.parallelize(Array("one","two","three","four","five"))          //创建数据集
//    val result = str.reduce(_ + _)                                       //进行数据拟合
//    result.foreach(print)                                               //打印数据结果
    //todo test 14
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("keyBy ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var str = sc.parallelize(Array("one","two","three","four","five"))          //创建数据集
//    val str2 = str.keyBy(word => word.size)                              //设置配置方法
//    str2.foreach(println)                                               //打印结果
    //todo test 13
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("groupBy ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var arr = sc.parallelize(Array(1,2,3,4,5))                             //创建数据集
//    arr.groupBy(myFilter(_), 1)									   //设置第一个分组
//    arr.groupBy(myFilter2(_), 2)                    //设置第二个分组
    //todo test 12
//    val conf = new SparkConf()                                      //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("testMap ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var arr = sc.parallelize(Array(1,2,3,4,5))                             //创建数据集
//    val result = arr.map(x => List(x + 1)).collect()                        //进行单个数据计算
//    result.foreach(println)
    //todo test 11
//    val conf = new SparkConf()                                      //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("flatMap ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var arr = sc.parallelize(Array(1,2,3,4,5))                             //创建数据集
//    val result = arr.flatMap(x => List(x + 1)).collect()                      //进行数据集计算
//    result.foreach(println)                                             //打印结果
    //todo test 10
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("filter ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var arr = sc.parallelize(Array(1,2,3,4,5))                             //创建数据集
//    val result = arr.filter(_ >= 3)                                        //进行筛选工作
//    result.foreach(println)
    //todo test 9
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("distinct ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var arr = sc.parallelize(Array(("cool"), ("good"), ("bad"), ("fine"),("good"),("cool")))  //创建数据集
//    val result = arr.distinct()                                           //进行去重操作
//    result.foreach(println)
    //todo test 8
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("countByKey ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    var arr = sc.parallelize(Array((1, "cool"), (2, "good"), (1, "bad"), (1, "fine")))  //创建数据集
//    val result = arr.countByKey()                                      //进行计数
//    result.foreach(print)
    //result (1,3)(2,1)

    //todo test 7
//    val conf = new SparkConf()                                       //创建环境变量
//      .setMaster("local")                                               //设置本地化处理
//      .setAppName("countByValue ")                                    	  //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    val arr = sc.parallelize(Array(1,2,3,4,5,6))						  //创建数据集
//    val result = arr.countByValue()								  //调用方法计算个数
//    result.foreach(print)
//   //result (5,1)(1,1)(6,1)(2,1)(3,1)(4,1)

    //todo test 6
//    val conf = new SparkConf()                                        //创建环境变量
//      .setMaster("local")                                                //设置本地化处理
//      .setAppName("Coalesce ")                                    	   //设定名称
//    val sc = new SparkContext(conf)						       //创建环境变量实例
//    val arr = sc.parallelize(Array(1,2,3,4,5,6))						  //创建数据集
//    val arr2 = arr.coalesce(2,true)                                     //将数据重新分区
//    val result = arr.aggregate(0)(math.max(_, _), _ + _)                  //计算数据值
//    println(result)                                                   //打印结果
//    val result2 = arr2.aggregate(0)(math.max(_, _), _ + _)               //计算重新分区数据值
//    println(result2)

    //todo test 5
//    var conf = new SparkConf().setMaster("local").setAppName("testRDDMethod2")
//    var sc = new SparkContext(conf)
//    var arr1 = sc.parallelize(Array(1,2,3,4,5,6))
//    var arr2 = sc.parallelize(Array(6,5,4,3,2,1))
//
//    var result = arr1.cartesian(arr2)//求笛卡尔积
//    result.foreach(print)

    //todo test 4
//    var conf = new SparkConf().setMaster("local").setAppName("testRDDMethod2")
//    var sc = new SparkContext(conf)
//    var arr = sc.parallelize(Array("a","b","c","123","d","e","abc","f"))
//    println(arr)
//    print("=========")
//    arr.foreach(println)
    //todo test 3
//    var conf = new SparkConf().setMaster("local").setAppName("testRDDMethod2")
//    var sc = new SparkContext(conf)
//    var arr = sc.parallelize(Array("a","b","c","123","d","e","abc","f"))
//    var result = arr.aggregate("")((value,word) => value + word,_+_)
//    print(result)
//
    //todo test 2
    var conf = new SparkConf().setMaster("local").setAppName("testRDDMethod")
    var sc = new SparkContext(conf)
    var arr = sc.parallelize(Array(1,2,3,4,5,5),3)//将array均分为两个数组，
    var result = arr.aggregate(0)(math.max(_,_),_+_)//将两个数组中最大值进行相加
//    println(result)

    //todo test 1
//    val conf = new SparkConf().setMaster("local").setAppName("wordCount")	//创建环境变量
//    val sc = new SparkContext(conf)								//创建环境变量实例
//    val data = sc.textFile("c://wc.txt")								//读取文件
//    data.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)	//word计数
//    print("sdfsdf")
  }
}
