pipeline {
    agent any
    stages {
        stage('git clone & clean') {
            steps {
               // bat "rmdir  /s /q InetBanking_Version4"
                bat "git clone https://github.com/ansonwalder/InetBanking_Version4.git"
                bat "mvn clean -f InetBanking_Version4"
            }
        }
        // stage('install') {
        //     steps {
        //         bat "mvn install -f InetBanking_Version4"
        //     }
        // }
        stage('test') {
            steps {
                bat "mvn test -f InetBanking_Version4"
            }
        }
        // stage('package') {
        //     steps {
        //         bat "mvn package -f InetBanking_Version4"
        //     }
        // }
    }
}
