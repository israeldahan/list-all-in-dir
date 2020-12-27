pipeline {
    agent { label 'aws'}
    parameters {
        string(name: 'USERNAME', defaultValue: 'ubuntu', description: 'insert user name')
        string(name: 'HOSTANME', defaultValue: '1.1.1.1', description: 'insert ip or hostname')
        string(name: 'DIRECTORYNAME', defaultValue: '/path/to/dir', description: 'insert path dir absolute')
        string(name: 'PASSWORD', defaultValue: '123456', description: 'insert password')
    }
    stage ('clone project'){
        steps {
            git branch: 'main', credentialsId: 'b5c6464c-b964-476b-ba36-d3ea0bdedd65', url: 'https://github.com/israeldahan/list-all-in-dir.git'
            sh 'gradle run'
        }
    }
    stage('build'){
        steps {
            System.out.println ' test jenkins'
        }
    }
}