podTemplate(containers: [containerTemplate(image: 'golang:latest', name: 'golang', command: 'cat', ttyEnabled: true)]) {
    podTemplate(containers: [containerTemplate(image: 'maven:alpine', name: 'maven', command: 'cat', ttyEnabled: true)]) {
        node(POD_LABEL) { // gets a pod with both docker and maven
            sh '''
            mvn -version
            go version
        '''
        }
    }
}
