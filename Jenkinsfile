#!groovy
@Library('global-libs@main')

import PodTemplates

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
