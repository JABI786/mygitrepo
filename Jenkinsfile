pipeline {
   agent any
   stages {
     stage ('Unit Test'){
	   steps{
	     sh 'ant -f test.xml -v'
		 junit 'reports/result.xml'
		    }
		   }  	
     stage ('build') {
       steps{
         sh 'echo build number is ${BUILD_NUMBER} '
         sh 'ant -f build.xml -v'
            }
          }
     stage ('deploy') {
        steps{
         sh "[ -d '/var/www/html/Person/all/${BRANCH_NAME}' ] || mkdir -p /var/www/html/Person/all/${BRANCH_NAME}"
         sh 'cp dist/Me_${BUILD_NUMBER}.jar /var/www/html/Person/all/${BRANCH_NAME}'
            }
         } 
     stage ("Running on Ubuntu") {
       steps{
         sh "wget http://127.0.0.1/Person/all/${BRANCH_NAME}/Me_${BUILD_NUMBER}.jar"
         sh "java -jar Me_${BUILD_NUMBER}.jar jabir 39"
            }
         }
      
    stage ("Running on Centos") {
       agent {
         docker 'jabi786/centos6-1.8.0-openjdk'
            }
       steps{
         sh "curl http://192.168.213.131/Person/all/${BRANCH_NAME}/Me_${BUILD_NUMBER}.jar --output Me_${BUILD_NUMBER}.jar"
         sh "java -jar Me_${BUILD_NUMBER}.jar jabir 39"
            }
         }
   stage ('Promote to Green') {
       when {
           branch master
          }

       steps{
         sh 'cp /var/www/html/Person/all/${BRANCH_NAME}/Me_${BUILD_NUMBER}.jar /var/www/html/Person/green/'
            }

       }
   stage ('Promote develop Branch to Master') {
       when {
           branch develop
          }
       steps{
         echo 'stashing any local changes'
         sh 'git stash'
         echo 'checking out develop branch'
         sh 'git checkout develop'
         echo 'checking out master branch'
         sh 'git checkout master'
         echo 'Merging develop into master branch'
         sh ' git merge develop'
         echo 'pushing to origin master'
         sh 'git push origin master'
         } 
       }
      }
   post   {
     always {
	    archive 'dist/*.jar'
		    }
		   }	
		  }

