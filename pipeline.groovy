println("Hello World")
println("ls".execute().text)
println("printenv".execute().text)
println("ls -al /var/jenkins_home/workspace/test-pipeline".execute().text)

def workspace = pwd()
println(workspace)
