pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Checkout GitHub repository
                checkout([$class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/Nagamani-Deeptimaan/jenkins-deployment-example']]
                ])

                // Build the project using Gradle
                bat 'gradlew.bat build'
            }
        }

        stage('Docker Build & Tag') {
            steps {
                // Build the Docker image locally
                bat "docker build -t springboot-gradle-app:0.1.RELEASE% ."
            }
        }

        stage('Push Docker image to Hub') {
            steps {
withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    bat """
    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
    """
}
                // Push the image to Docker Hub
                bat "docker push mannenagamani/jenkinsexample"
            }
        }
    }
}
