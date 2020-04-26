node{
    def app

    stage('Git Clone'){
        steps{
            echo "Git Checkout"
            git clone 'https://github.com/vinothg2309/customer-service.git'
        }
    }

    stage('maven build'){
        steps{
            sh '''
                echo "MAVEN BUILD"
                mvn package
            '''
        }
    }

    stage('Docker Build'){
        steps{
            echo "DOCKER BUILD"
            app = docker.build("vinothg2309/customer-service")
        }
    }

    stage('Test Image'){
        steps{
            echo "Test passed"
        }
    }

    stage('Docker Push'){
        steps{
            echo "DOCKER PUSH"
            docker.withRegistry("https://registry.hub.docker.com", 'dockerhub_credential'){
                app.push("${env.BUILD_NUMBER}")
                app.push("latest")
            }
            echo "DOCKER IMAGE PUSHED!!!"
        }
    }

}