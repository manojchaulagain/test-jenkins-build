#!groovy
@Library('global-libs@main')

import PodTemplates

podTemplates = new PodTemplates()
podTemplates.mavenTemplate {
    node(POD_LABEL) {
        container('maven') {
            sh "echo hello from $POD_CONTAINER" // displays 'hello from maven'
        }
    }
}
