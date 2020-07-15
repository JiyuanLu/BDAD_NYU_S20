import scala.io.Source
import java.io.File
import java.io.PrintWriter
import scala.util.matching.Regex

val file_Object = new File("/home/jl11046/BDAD/bdad_hw2/hw2_partD_output.txt")
val print_Writer = new PrintWriter(file_Object)

val pattern = "[0-9]+(.[0-9]+){3}".r
var count = 0

for(line <- Source.fromFile("/home/jl11046/BDAD/bdad_hw2/2014-03-15.log").getLines){
    if (line.contains(".jpg")){
        count += 1
        val ip = (pattern findFirstIn line).get
        print_Writer.write(line.length.toString + " - " + ip + " - " + line + "\n")
    }
} 

print_Writer.write("\n")
print_Writer.write("There were " + count.toString + " jpg requests." + "\n")
print_Writer.close()