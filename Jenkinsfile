node ('aws'){
    stage ('clone project'){
        git branch: 'main', credentialsId: 'b5c6464c-b964-476b-ba36-d3ea0bdedd65', url: 'git@github.com:israeldahan/list-all-in-dir.git'
        sh 'ls -al'
    }
    stage('build'){
        System.out.println ' test jenkins'
    }
}