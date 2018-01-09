package scalalg.me.libme.module.kafka

import java.util

import me.libme.kernel._c._i.JParser

/**
  * Created by J on 2018/1/9.
  */
object TopicPartitionParser extends JParser{



  def topic(str:String):String={
    str.split("::")(0)
  }

  def partition(str:String):java.util.List[Integer]={
    val list=new util.ArrayList[Integer]()
    val ar=str.split("::")
    for(i<-1 until ar.length){
      list.add(Integer.parseInt(ar(i)))
    }

    return list

  }



}
