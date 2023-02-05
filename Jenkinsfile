podTemplate(yaml: readTrusted('pod-mvn.yaml')) {
    podTemplate(yaml: readTrusted('pod-go.yaml')) {
        node(POD_LABEL) {
            stage('Get a Maven project') {
                git 'https://github.com/jenkinsci/kubernetes-plugin.git'
                container('golang') {
                    stage('Build a Maven project') {
                        sh 'printenv'
                    }
                }
            }

            stage('Get a Golang project') {
                git url: 'https://github.com/hashicorp/terraform.git', branch: 'main'
                container('golang') {
                    stage('Build a Go project') {
                        sh '''
                    go version
                    printenv
                    ls -al
                    '''
                    }
                }
            }
        }
    }
}

