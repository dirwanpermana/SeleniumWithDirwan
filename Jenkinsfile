pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10'
        jdk 'Java 21'
    }

    environment {
        TELEGRAM_BOT_TOKEN = '8043792854:AAHr9UCIdGb_KK0i95SGIrEqAt7o7e3yoKA'
        TELEGRAM_CHAT_ID = '999930518'
    }

    stages {
        stage('Clone Source') {
            steps {
                git branch: 'main', url: 'https://github.com/dirwanpermana/SeleniumWithDirwan.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
                // bat 'mvn clean test -DsuiteXmlFile=selenium.xml'
            }
        }
        stage('Publish Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
                cucumber buildStatus: 'UNSTABLE', fileIncludePattern: '**/cucumber-reports/*.json'
            }
        }
    }

    post {
        success {
            script {
                def message = URLEncoder.encode("Testing lu aman bro, sikatt!! \nJob: ${env.JOB_NAME}\nBuild #: ${env.BUILD_NUMBER}\nURL: ${env.BUILD_URL}", "UTF-8")
                sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text=${message}"
                echo 'Build success cuyy!'
            }
        }
        failure {
            script {
                def message = URLEncoder.encode("Testing FAILED Cuy, Benerin Lagi \nJob: ${env.JOB_NAME}\nBuild #: ${env.BUILD_NUMBER}\nURL: ${env.BUILD_URL}", "UTF-8")
                sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text=${message}"
                echo 'Build failed.'
            }
        }
    }
}
