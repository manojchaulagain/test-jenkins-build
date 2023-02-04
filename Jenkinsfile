podTemplates = new PodTemplates()
podTemplates.dockerTemplate {
  podTemplates.mavenTemplate {
    node(POD_LABEL) {
      container('docker') {
        sh "echo hello from $POD_CONTAINER" // displays 'hello from docker'
      }
      container('maven') {
        sh "echo hello from $POD_CONTAINER" // displays 'hello from maven'
      }
     }
  }
}

podTemplate(yaml: readTrusted('pod-mvn.yaml')) {
    podTemplate(yaml: readTrusted('pod-go.yaml')) {
        node(POD_LABEL) {
            stage('Run maven and go commands') {
                git 'https://github.com/jenkinsci/kubernetes-plugin.git'
                sh '''
                go -version
                mvn -version
                '''
            }

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