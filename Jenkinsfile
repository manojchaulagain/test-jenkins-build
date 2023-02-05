podTemplate(containers: [containerTemplate(image: 'golang:latest', name: 'golang', command: 'cat', ttyEnabled: true)]) {
    podTemplate(containers: [containerTemplate(image: 'maven:alpine', name: 'maven', command: 'cat', ttyEnabled: true)]) {
        podTemplate(containers: [containerTemplate(image: 'docker:latest', name: 'docker', args: '--privileged', command: 'cat', ttyEnabled: true)]) {
            node(POD_LABEL) { // gets a pod with both docker and maven
                container('golang') {
                    sh 'go version'
                }
                container('maven') {
                    sh 'mvn -version'
                }
                container('docker') {
                    sh 'docker version'
                }
            }
        }
    }
}
