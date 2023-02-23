import static groovy.io.FileType.FILES

println("Hello World")
println("ls".execute().text)
println("printenv".execute().text)
println("ls -al /var/jenkins_home/test-pipeline".execute().text)
println("ls -al /var/jenkins_home/testjobs/test-pipeline".execute().text)



new File(${WORKSPACE} + '/testjobs/test-pipeline').eachFileRecurse(FILES) {
    if(it.name.endsWith('.groovy')) {
        println it
    }
}
