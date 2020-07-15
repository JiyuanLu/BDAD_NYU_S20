// a. Load the dataset
val records = sc.textFile("hw4/devicestatus.txt")

// b. Determine the delimiters and parse each record
val fields = records.map(line => line.split(line(19)))

// c. Filter out records which do not parse to 14 fields
val valid = fields.filter(_.length == 14)

// d. Extract the date, mfr_model, device ID, latitude, longitude
// e. For mfr_model, keep only the manufacturer
val useful = valid.map(line => (line(0), line(1).split(" ")(0), line(2), line(12), line(13)))

// f. Save as comma delimited file, trim the starting '( 'and ending ')'
val trimmed = useful.map(line => line.toString.slice(1, line.toString.length - 1))
trimmed.saveAsTextFile("loudacre/devstatus/devicestatus_etl")