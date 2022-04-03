//@Library('LibraryName') _ 
// Declarative pipeline

@Library('LandmarkSS-sharedlibs') _
pipeline {
agent any 
tools {
    maven "maven3.8.5"
  }
stages{
stage('CheckoutCode'){
  steps{
    git 'https://github.com/LandmakTechnology/paypal-web-app'
}
}
stage("Build"){ 
  steps{
    common("Build")  
}
}
stage("Execute SonarQube Report"){ 
  steps{
    common("SonarQube Report")
}
}
stage("Upload Artifacts Into Nexus"){ 
  steps{
    common("Upload Into Nexus")
}
}
}
}
