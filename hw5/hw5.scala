val setupCountsRDD = sc.textFile("loudacre/weblog").map(line => line.split(" ")).map(fields => (fields(2), 1))
val requestCountsRDD = setupCountsRDD.reduceByKey(_ + _)
val visitFrequencyTotalsRDD = requestCountsRDD.map(pair => (pair._2, 1)).reduceByKey(_ + _)
val accounts = sc.textFile("loudacre/accounts").map(line => line.split(",")).map(fields => (fields(0), Unit))
val ips = sc.textFile("loudacre/weblog").map(line => line.split(" ")).map(fields => (fields(2), fields(0))).groupByKey
val validAcctsIpsFinalRDD = accounts.join(ips).map(pair => (pair._1, pair._2._2.toList))