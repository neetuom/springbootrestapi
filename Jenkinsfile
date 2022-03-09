node{
    stage('SCM checkout'){
        // You can choose to clean workspace before build as follows
        cleanWs()
        git credentialsId: 'Token_Springbootapi', url: 'https://github.com/neetuom/springbootrestapi.git'
    }

/*    stage("MVN Package"){
        def mavenHome = tool name: 'Maven_3', type: 'maven'
        def mavenCMD = "${mavenHome}/bin/mvn"
        sh "${mavenCMD} clean package"
    }
*/
    stage("Gradle Build"){
        sh './gradlew build'
    }

    stage("Docker build & Deploy"){
      withCredentials([string(credentialsId: 'dockPass', variable: 'dockPassword')]) {
         sh 'docker --version'
         sh "docker login -u neetuom -p ${dockPassword}"
      }
      sh 'docker-compose -f docker-compose.restapi.yml build'
      sh 'docker-compose -f docker-compose.restapi.yml up -d'
    }
}