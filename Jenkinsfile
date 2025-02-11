pipeline {
    agent any

    stages {
        stage('Tests') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
                    bat 'gradlew.bat test'
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
