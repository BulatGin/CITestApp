pipeline {
    agent any

    tools {
        maven 'DefaultMaven'
    }

    environment {
        IMAGE = 'bulatgin/ci-test:latest'
    }

    stages {
        stage('Prebuild') {
            steps {
                sh "mvn package -Dmaven.test.skip=true"
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('DockerBuild') {
            steps {
                sh "docker image prune -f"
                sh "docker build -t ${IMAGE} ."
                withCredentials([usernamePassword(credentialsId: 'dockerHubCredentials', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUsername')]) {
                    sh "docker login -u ${dockerHubUsername} -p ${dockerHubPassword}"
                }
                sh "docker push ${IMAGE}"
            }
        }
    }
}