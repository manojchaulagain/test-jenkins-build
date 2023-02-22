import static groovy.io.FileType.FILES

println("Hello World")
println("ls".execute().text)
println("printenv".execute().text)
println("ls -al /var/jenkins_home/workspace/test-pipeline".execute().text)



new File(System.getenv('JENKINS_HOME') + '/workspace/test-jobs/test-pipeline').eachFileRecurse(FILES) {
    if(it.name.endsWith('.groovy')) {
        println it
    }
}
