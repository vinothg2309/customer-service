pipeline{
    agent any
    stages{
        stage('Compile'){
            steps{
                echo "compiled Successfully!!!!"
            }
        }
        stage('Junit'){
            steps{
                echo "JUNUIT Passed successfully!!!"
            }
        }
        stage('Quality Gate'){
            steps{
                echo "SonarQube Quality Gate Passed successfully!!!"
            }
        }
        stage('Deploy'){
            steps{
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