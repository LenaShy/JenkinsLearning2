import java.io.*
import groovy.io.*;

@NonCPS
def call(Map configure=[:]) {
  def dir = new File(pwd())
  
  println dir
  
  new File(dir.path + '/releasenotes/releasenotes.txt').withWriter('utf-8')
  {
    writer ->
      dir.eachFileRecurse(FileType.ANY) { file ->
        if (file.isDirectory()) {
          writer.writeLene(file.name)
        }
        else
        {
          writer.writeLine('\t' + file.name + '\t' + file.length())
        }
      }
  }
}
