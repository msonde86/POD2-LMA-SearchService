pipeline {
  environment {
    JAVA_TOOL_OPTIONS = "-Duser.home=/home/jenkins"
  }
  agent {
    dockerfile {
      args "-v /tmp/maven:/home/jenkins/.m2 -e MAVEN_CONFIG=/home/jenkins/.m2"
     }
  }
  
  stages {
    stage("Build") {
      steps {
        bat "ssh -V"
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
   
