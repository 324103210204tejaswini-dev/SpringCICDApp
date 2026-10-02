pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Spring Boot application...'
                bat 'mvnd clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                bat 'mvnd test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                bat 'docker build --no-cache -t spring-cicd-app .'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'

                bat '''
                    docker stop spring-cicd-container || exit 0
                    docker rm spring-cicd-container || exit 0
                    docker run -d -p 9090:9090 --name spring-cicd-container spring-cicd-app
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'CI/CD Pipeline failed!'
        }
    }
}