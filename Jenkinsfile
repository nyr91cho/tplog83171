pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Cette étape récupère le code (le même que défini dans la config SCM du job Jenkins)
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                // On se déplace dans le dossier 'sonarqube-master'
                dir('sonarqube-master') {
                    // Sur Windows, on exécute la commande batch 
                    catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
                    bat 'gradlew.bat test'
                }
                }
            }
        }
                stage('Autres étapes') {
            steps {
                echo "Le pipeline continue malgré un ou plusieurs tests en échec."
            }
        }
    }
}
