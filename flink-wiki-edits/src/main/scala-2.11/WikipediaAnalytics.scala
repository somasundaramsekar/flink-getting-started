package com.ta

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.connectors.wikiedits.{WikipediaEditEvent, WikipediaEditsSource}


object WikipediaAnalytics extends App{

  val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

  val edits = env.addSource(new WikipediaEditsSource())

  val keyedEdits = edits.keyBy(event => event.getUser)

  val result_1: (((String, Long), WikipediaEditEvent) => (String, Long)) => DataStream[(String, Long)] =
    keyedEdits.timeWindow(Time.seconds(5)).fold(("", 0L))

  val result_2: DataStream[(String, Long)] = result_1((t: (String, Long), we: WikipediaEditEvent ) =>
    (we.getUser, t._2 + we.getByteDiff))

  /*val result =
    keyedEdits.timeWindow(Time.seconds(5)).fold(("", 0L), (t: (String, Long), we: WikipediaEditEvent ) =>
    (we.getUser, t._2 + we.getByteDiff))*/


  result_2.print()

  env.execute();


}
