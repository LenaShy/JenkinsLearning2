import java.io.*
import groovy.io.*
import java.util.Calendar.*
import java.text.SimpleDateFormat

@NonCPS
def call(Map config=[:]) {
  def dir = new File(pwd())
  
  println dir
  
  def date = new Date()
  def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
  echo "Date and Time IS: " + sdf.format(date)
  
  echo "Build Number is: $(BUILD_NUMBER)"
  
  if (config.changes != "false") {
    echo "changes"
  }
}
