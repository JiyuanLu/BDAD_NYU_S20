// spark2-shell
val exchangeRate : Double = 0.55
val dollars : Int = 100.00
val dollars : Int = 100
var euros = 0.00
euros = dollars * exchangeRate
dollars = 500
var dollars = 500
dollars = 500.00
var eurosInt : Int = 0
eurosInt = dollars * exchangeRate
eurosInt = dollars * exchangeRate.toInt
// The result is: eurosInt : Int = 0. It is not a useful result. We converted exchangeRate(0.55) to 0 by applying toInt.