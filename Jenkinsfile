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
                sh 'gradle build'
            }
        }
        stage('build'){
            steps {
                println ' test jenkins'
            }
        }
    }
}