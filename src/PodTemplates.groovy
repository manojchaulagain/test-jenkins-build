public void dockerTemplate(body) {
  podTemplate(
        containers: [containerTemplate(name: 'docker', image: 'docker', command: '', args: '')]) {
    body.call()
        }
}

public void mavenTemplate(body) {
  podTemplate(
        containers: [containerTemplate(name: 'maven', image: 'maven', command: '', args: '')]) {
    body.call()
        }
}

return this
