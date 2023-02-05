podTemplate(containers: [containerTemplate(image: 'golang', name: 'golang', command: 'cat', ttyEnabled: true)]) {
    podTemplate(containers: [containerTemplate(image: 'maven', name: 'maven', command: 'cat', ttyEnabled: true)]) {
        node(POD_LABEL) { // gets a pod with both docker and maven
            sh '''
            go version
            mvn -version
        '''
        }
    }
}
