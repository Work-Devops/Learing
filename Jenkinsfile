pipeline {
    agent any

    tools {
        maven 'mymaven'  // Ensure Maven is configured in Jenkins
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/yourusername/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed'
        }
        success {
            echo 'Build succeeded'
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo 'Build failed'
        }
        unstable {
            echo 'Build is unstable'
        }
    }
}
