def IMAGE="bulatgin/ci-test:latest"

node {
    stage('Initialization') {
        def dockerHome = tool 'DefaultDocker'
        def mavenHome  = tool 'DefaultMaven'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }

    stage('Prebuild') {
        sh "mvn clean compile"
    }

    stage('Test') {
        sh "mvn test"
    }

    stage('DockerBuild') {
        sh "mvn package -Dmaven.test.skip=true"
        sh "docker image prune -f"
        sh "docker build -t ${IMAGE}"
        withCredentials([usernamePassword(credentialsId: 'dockerHubCredentials', usernameVariable: 'username', passwordVariable: 'password')]) {
            sh "docker login -u $password -p $password"
        }
        sh "docker push ${IMAGE}"
    }
}