pipeline{
    agent any
    stages{
        stage('Git-Checkout'){
            steps{
                echo "Git Checkout"
                git 'https://github.com/vinothg2309/Jenkins_Git.git'
            }
        }
        stage('Build'){
            steps{
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
                echo "Build Passed successfully!!!"
            }
        }
        stage('Junit'){
            steps{
                script: 'sh ./Unit.sh'
                echo "JUNIT Passed successfully!!!"
            }
        }
        stage('Quality Gate'){
            steps{
                script: 'sh ./Quality.sh'
                echo "SonarQube Quality Gate Passed successfully!!!"
            }
        }
        stage('Deploy'){
            steps{
                script: 'sh ./Deploy.sh'
                echo "Deployed successfully!!!"
            }
        }
    }
    post{
        always{
            echo "This will always run"
        }
        success{
            echo "This will only run if successful"
        }
        failure{
            echo "This will only run if failed"
        }
        unstable{
            echo "This will only run if the run was marked as unstable"
        }
        changed{
            echo "This will only run if the state of pipeline has changed"
            echo "E.g : If pipeline is previously failing but now successful"
        }
    }
}