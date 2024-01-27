properties([parameters([activeChoice(choiceType: 'PT_SINGLE_SELECT', description: 'Select a Service Name', filterLength: 1, filterable: false, name: 'SERVICE_NAME', randomName: 'choice-parameter-1120679675952', script: groovyScript(fallbackScript: [classpath: [], oldScript: '', sandbox: false, script: ''], script: [classpath: [], oldScript: '', sandbox: false, script: '''return [\'Option 1\', \'Option 2\', \'Option 3\']
'''])), activeChoiceHtml(choiceType: 'ET_ORDERED_LIST', description: 'Select a Node Type', name: 'NODE_TYPE', omitValueField: true, randomName: 'choice-parameter-1120689683646', referencedParameters: 'SERVICE_NAME', script: groovyScript(fallbackScript: [classpath: [], oldScript: '', sandbox: false, script: ''], script: [classpath: [], oldScript: '', sandbox: false, script: '''if(SERVICE_NAME.equals("jenkins")) {
    return [\'Option 1\', \'Option 2\', \'Option 3\']
} else if (SERVICE_NAME.equals("jenkins-onprem")) {
    return [\'Node 1\', \'Node 2\', \'Node 3\']
}''']))])])
podTemplate(yaml: readTrusted('pod.yaml')) {
    node(POD_LABEL) {
        writeFile file: 'Dockerfile', text: 'FROM scratch'
        container('docker') {
            sh 'docker version && DOCKER_BUILDKIT=1 docker build --progress plain -t testing .'
        }
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
                    go version
                    '''
                }
            }
        }
    }
}
