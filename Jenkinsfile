node {
  stage('SCM') {
    echo 'Gathering code from version control'
  }
  stage('Build') {
    echo 'Building...'
    releasenotes()
  }
  stage('Test') {
    echo 'Testing...'
  }
  stage('Deploy') {
    echo 'Deploying...'
  }
}
