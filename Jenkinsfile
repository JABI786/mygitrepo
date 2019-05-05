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
         sh 'echo ${env.BUILD_NUMBER}'
         sh 'ant -f build.xml -v'
            }
          }
     stage ('deploy') {
       steps{
         sh 'cp dist/Me_${BUILD_NUMBER}.jar /var/www/html/Person/all/'
            }
         } 
     stage ("Running on Ubuntu") {
       steps{
         sh "wget http://192.168.213.146/Person/all/Me.jar"
         sh "java -jar Me.jar jabir 39"
            }
         }
      
    stage ("Running on Centos") {
       agent {
         docker 'jabi786/centos6-1.8.0-openjdk'
            }
       steps{
         sh "curl http://192.168.213.146/Person/all/Me.jar --output Me.jar"
         sh "java -jar Me.jar jabir 39"
            }
         }
   stage ('Promote to Green') {
       steps{
         sh 'cp /var/www/html/Person/all/Me.jar /var/www/html/Person/green/'
            }
         }

       }

   post   {
     always {
	    archive 'dist/*.jar'
		    }
		   }	
		  }

