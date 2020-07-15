import scala.xml._

// Given a string containing XML, parse the string, and return an iterator of activation XML records(Nodes) contained in the string.
def getActivations(xmlstring: String): Iterator[Node] = {
    val nodes = XML.loadString(xmlstring)   \\"activation"
    nodes.toIterator
}

// Given an activation record (XML Node), return the model name
def getModelName(activation: Node): String = {
    (activation \ "model").text
}

// Given an activation record (XML Node), return the account number
def getAccountNumber(activation: Node): String = {
    (activation \ "account-number").text
}

val input_path = "loudacre/activations"
val output_path = "loudacre/activations/account-models"
val rdd = sc.wholeTextFiles(input_path) // (fileName, fileContent)
val xml_strs = rdd.map(pair => pair._2) // fileContent: String
val nodes_its = xml_strs.map(str => getActivations(str)) // Iterator[Node]
val records = nodes_its.flatMap(identity)
val fields = records.map(node => (getAccountNumber(node), getModelName(node)))
val formatted_str = fields.map(pair => String.format("%s:%s", pair._1, pair._2))
formatted_str.saveAsTextFile(output_path)