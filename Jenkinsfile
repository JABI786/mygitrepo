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
       } 
   post   {
     always {
	    archive 'dist/*.jar'
		    }
		   }	
		  }


