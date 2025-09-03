pipeline {
	agent any

	tools {
		maven 'M3'
		jdk 'JDK21'
	}

	stages {
		stage('Checkout') {
			steps {
				git branch: 'main',
				url: 'https://github.com/AminAlsuhaibani/calc-Project.git'
			}
		}

		stage('Build') {
			steps {
				sh 'mvn clean compile'
			}
		}

		stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
	}

	post {
        success {
            emailext(
                to: 'amunh3333@gmail.com',
                subject: "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build succeeded! Check details: ${env.BUILD_URL}",
                smtpUsername: 'aminalsuhaibani@gmail.com',
                smtpPassword: credentials('email-creds')
            )
        }
        failure {
            emailext(
                to: 'amunh3333@gmail.com',
                subject: "❌ FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build failed! Check logs: ${env.BUILD_URL}",
                smtpUsername: 'aminalsuhaibani@gmail.com',
                smtpPassword: credentials('email-creds')
            )
        }
    }
}