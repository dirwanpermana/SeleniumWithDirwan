pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10'    // Sesuaikan dengan konfigurasi Jenkins kamu
        jdk 'Java 21'          // Atau Java 11/21 sesuai versi yang kamu pakai
    }

    stages {
        stage('Clone Source') {
            steps {
                git 'https://github.com/dirwanpermana/SeleniumWithDirwan.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo 'Build success cuyy!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
