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
         sh 'ant -f build.xml -v'
            }
          }
     stage ('deploy') {
       steps{
         sh 'cp dist/Me.jar /var/www/html/Person/all/'
            }
         } 
     stage ("Running on Ubuntu") {
       steps{
         sh "wget http://192.168.213.146/Person/all/Me.jar"
         sh "java -jar Me.jar jabir 39"
            }
         }
       }
    stage ("Running on Centos") {
       agent {
         docker 'jabi786/centos6-1.8.0-openjdk'
            }
       steps{
         sh "wget http://192.168.213.146/Person/all/Me.jar"
         sh "java -jar Me.jar jabir 39"
            }
         }
       }

   post   {
     always {
	    archive 'dist/*.jar'
		    }
		   }	
		  }


