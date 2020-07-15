val rdd1 = sc.textFile("loudacre/accounts").keyBy(line => line.split(",")(8))
val rdd2 = rdd1.mapValues(line => (line.split(",")(3), line.split(",")(4))).groupByKey()
val rdd3 = rdd2.sortByKey()
rdd3.take(5).foreach{line => println("--- " + line._1) 
                             line._2.foreach(name => println(name._1 + "," + name._2))
                             println()}