podTemplate(yaml: readTrusted('pod.yaml')) {
    node(POD_LABEL) {
        stage('Get a Maven project') {
            git 'https://github.com/jenkinsci/kubernetes-plugin.git'
            container('maven-alpine') {
                stage('Build a Maven project') {
                    sh 'mvn -version'
                }
            }
        }
        
        stage('Run busybox') {
            container('busybox') {
                stage('Running busybox') {
                    sh '/bin/busybox'
                }
            }
        }

        stage('Get a Golang project') {
            git url: 'https://github.com/hashicorp/terraform.git', branch: 'main'
            container('golang') {
                stage('Build a Go project') {
                    sh '''
                    printenv
                    ls -al
                    go -version
                    '''
                }
            }
        }

    }
}