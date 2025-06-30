// pipeline {
//     agent any

//     tools {
//         maven 'Maven 3.9.10'    // Sesuaikan dengan konfigurasi Jenkins kamu
//         jdk 'Java 21'          // Atau Java 11/21 sesuai versi yang kamu pakai
//     }

//     stages {
//         stage('Clone Source') {
//             steps {
//                 // git 'https://github.com/dirwanpermana/SeleniumWithDirwan.git'
//                 git branch: 'main', url: 'https://github.com/dirwanpermana/SeleniumWithDirwan.git'

//             }
//         }

//         stage('Run Tests') {
//             steps {
//                 bat 'mvn clean test'
//             }
//         }
//     }

//     post {
//         success {
//             echo 'Build success cuyy!'
//         }
//         failure {
//             echo 'Build failed.'
//         }
//     }
// }

/* Jenkins dengan notifikasi Telegram */
 
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
            }
        }
    }

    post {
        success {
            script {
                def message = URLEncoder.encode("✅ Build SUCCESS 🎉\nJob: ${env.JOB_NAME}\nBuild #: ${env.BUILD_NUMBER}\nURL: ${env.BUILD_URL}", "UTF-8")
                sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text=${message}"
                echo 'Build success cuyy!'
            }
        }
        failure {
            script {
                def message = URLEncoder.encode("❌ Build FAILED 🚨\nJob: ${env.JOB_NAME}\nBuild #: ${env.BUILD_NUMBER}\nURL: ${env.BUILD_URL}", "UTF-8")
                sh "curl -s -X POST https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/sendMessage -d chat_id=${TELEGRAM_CHAT_ID} -d text=${message}"
                echo 'Build failed.'
            }
        }
    }
}
