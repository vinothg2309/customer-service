node{
    def app

    stage('Git Clone'){
            git 'https://github.com/vinothg2309/customer-service.git'
     }

    stage('maven build'){
            sh '''
                echo "MAVEN BUILD"
                mvn package
            '''
    }

    stage('Docker Build'){
            echo "DOCKER BUILD"
            app = docker.build("vinothg2309/customer-service")
    }

    stage('Test Image'){
            echo "Test passed"
    }

    stage('Docker Push'){
            echo "DOCKER PUSH"
            docker.withRegistry("https://registry.hub.docker.com", 'dockerhub_credential'){
                app.push("${env.BUILD_NUMBER}")
                app.push("latest")
            }
            echo "DOCKER IMAGE PUSHED!!!"

    }

}
