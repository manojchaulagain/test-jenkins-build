import static groovy.io.FileType.FILES

println("Hello World")
println("ls".execute().text)
println("printenv".execute().text)
println("ls -al /var/jenkins_home/workspace/test-pipeline".execute().text)
println("ls -al /var/jenkins_home/workspace/testjobs/test-pipeline".execute().text)



new File(System.getenv('JENKINS_HOME') + '/workspace/testjobs/test-pipeline').eachFileRecurse(FILES) {
    if(it.name.endsWith('.groovy')) {
        println it
    }
}
