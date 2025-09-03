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
    		always {
    			cleanWs()
    		}
    		success {
    			echo 'Pipeline completed successfully! Test2    '
    			mail to: 'amunh3333@gmail.com',
                subject: "Zo6: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                body: "Good news! The build succeeded.\nCheck the build details here: ${env.BUILD_URL}"

    		}
    		failure {
    			echo 'Pipeline failed!'
    		}
    	}
}