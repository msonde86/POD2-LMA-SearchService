pipeline {
  agent any
  
  stages {
    stage("Build") {
      steps {
        bat "mvn -version"
        bat "mvn -f loan-search-service/pom.xml clean install"
      }
    }
  }

  post {
   always {
    cleanWs()
  }
  }
}
   
