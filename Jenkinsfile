pipeline {
    agent { label 'aws'}
    parameters {
        string(name: 'USERNAME', defaultValue: 'ubuntu', description: 'insert user name')
        string(name: 'HOSTANME', defaultValue: '1.1.1.1', description: 'insert ip or hostname')
        string(name: 'DIRECTORYNAME', defaultValue: '/path/to/dir', description: 'insert path dir absolute')
        string(name: 'PASSWORD', defaultValue: '123456', description: 'insert password')
    }
    stages {
        stage ('clone project'){
            steps {
                checkout scm
            }
        }
        stage('check java') {
            steps {
                sh "java -version"
            }
        }
        stage('clean') {
          steps {
              sh "chmod +x gradlew"
              sh "./gradlew clean --no-daemon"
          }
        }
        stage('build'){
            steps {
                println ' test jenkins'
            }
        }
    }
}