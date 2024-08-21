pipeline {
    agent any

    tools {
        maven 'Maven 3.x'
    }

    environment {
        SONARQUBE_SCANNER_HOME = tool name: 'SonarQube Scanner'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-repo/your-project.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    withCredentials([string(credentialsId: 'sonarcloud-token', variable: 'SONAR_TOKEN')]) {
                        sh "mvn sonar:sonar \
                            -Dsonar.projectKey=your-project-key \
                            -Dsonar.organization=your-organization \
                            -Dsonar.host.url=https://sonarcloud.io \
                            -Dsonar.login=${SONAR_TOKEN}"
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 1, unit: 'HOURS') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }
    }
}
