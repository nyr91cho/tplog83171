pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                dir('sonarqube-master') {
                    bat 'gradlew.bat test'
                }
            }
        }
    }
    post {
        always {
            // Récupère tous les rapports XML de tests de tous les modules
            junit '**/build/test-results/**/*.xml'
        }
    }
}

