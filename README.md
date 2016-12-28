#Apache Flink  - a Startup Guide

##Introduction
##Why Flink
##Flink Architecture
##Flink Parallelism
##Flink Performance Benchmark
##Flink vs Other stream processing platforms
##Getting the feet wet
###Installation 
**Java 8 must be installed!**

   You can check the correct installation of Java by issuing the following command:

    java -version

If you have Java 8, the output will look something like this:

    java version "1.8.0_111"
    Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
    Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)

Download and build Flink

    $ git clone https://github.com/apache/flink.git
    $ cd flink
    $ mvn clean package -DskipTests # this will take up to 10 minutes
    $ cd build-target               # this is where Flink is installed to

<iframe width="560" height="315" src="//www.youtube.com/embed/QOdW1OuZ1U0?list=PLol_ykYs3OQ4Zypr1WGaYcSowzoMmcj4G" frameborder="0" allowfullscreen></iframe>
    
    <iframe width="854" height="480" src="https://www.youtube.com/embed/yrRPLBYiiEc" frameborder="0" allowfullscreen></iframe>


