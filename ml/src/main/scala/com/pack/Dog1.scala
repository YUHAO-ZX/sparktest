/**
  * Created by niceday on 17/3/3.
  */

import java.io.PrintWriter

import scala.collection.mutable
import scala.io.Source

object ReadShopInfo{
  def main(args: Array[String]) {
    val list = new mutable.LinkedHashSet[String]()
    Source.fromFile("/Users/niceday/Downloads/dataset/user_view.txt", "UTF-8")
      .getLines().foreach(str => list.add(str))

    var map = mutable.Map[String,Int]()

    println("read finish")
    list.foreach(line => {
      val items = line.split(",")
      var itemKey = items(1)+" "+items(2).split(" ")(0)
      if(map.contains(itemKey)){
        map.update(itemKey,map(itemKey)+1)
      }else{
        map += (itemKey -> 1)
      }
    })

    println("deal finish")

    var file = new PrintWriter("/Users/niceday/countData.txt")

    map.keys.foreach(key => {
      file.write(key+" "+map(key)+"\n")
    })

    file.close()


  }

}