pipeline {
  agent {
    docker {
      image "maven:3.6.0-jdk-13"
     }
  }
  
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
   
