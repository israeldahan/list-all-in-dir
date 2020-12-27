pipeline {
    agent { label 'aws'}
    parameters {
        string(name: 'USERNAME', defaultValue: 'ubuntu', description: 'insert user name')
        string(name: 'HOSTANME', defaultValue: '1.1.1.1', description: 'insert ip or hostname')
        string(name: 'DIRECTORYNAME', defaultValue: '/path/to/dir', description: 'insert path dir absolute')
        string(name: 'PASSWORD', defaultValue: '123456', description: 'insert password')
        string(name: 'KEY', defaultValue: '/path', description: 'insert path to key')
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
                sh './gradlew build --no-daemon'
            }
        }
        stage('run'){
            steps {
                sh 'rm -rf ./run-jar'
                sh 'mkdir ./run-jar'
                sh 'cp ${WORKSPACE}/build/libs/*.jar ${WORKSPACE}/run-jar/getList.jar'
                sh 'java  -DuserName="${params.USERNAME}"  -DhostName="${params.HOSTANME}"  -Dkey="${params.KEY}" -Ddirectory="${params.DIRECTORYNAME}" -jar ${WORKSPACE}/run-jar/getList.jar'
            }
        }

    }
}