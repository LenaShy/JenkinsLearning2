import java.io.*
import groovy.io.*
import java.util.Calendar.*
import java.text.SimpleDateFormat
import hudson.model.*

@NonCPS
def call(Map config=[:]) {
  def dir = new File(pwd())
  
  def date = new Date()
  def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
  echo "Date and Time IS: " + sdf.format(date)
  
  //echo "Build Number is: $(BUILD_NUMBER)" do not work dffghhj
  
  def changeLogSets = currentBuild.changeSets;
  
  for(change in changeLogSets) {
    def entries = change.items
    for(entry in entries) {
      echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}"
      for (file in entry.affectedFiles) {
        echo "${file.editType.name} ${file.path}"
      }
    }
  }
  
  if (config.changes != "false") {
    echo "changes"
  }
}
