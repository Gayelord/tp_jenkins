//
// 1 - Variable d'environnement
//
node {

  stage('0- clean'){
    deleteDir()
    checkout scm
  }

  stage ('1- Print Jenskins variables'){
    echo "env.GLOBAL_JENKINS_VARIABLE"
  }
  stage ('1- Print all env'){
    echo 'Affiche toutes les variables environnement disponibles :'
    sh 'env'
  }
}

//
// 2 - ParamÃ¨tres utilisateurs du script
//

node {
  stage('2- Print parameter'){
    sh '''
       echo "Affichage du paramÃ¨tre saisie par l'utilisateur"
       echo "  valeur du paramÃ¨tre : $missing_param"
    '''

    // Pour rÃ©cupÃ©rer la valeur dans le script
    def value = params.param_string
    def value_upper = params.param_string.toUpperCase()

    println "Print default => " + params.param_string
    println "Print default => " + value
    println "Print upper case value => " + value_upper

  }
}

//
// 3 - Credentials
//

node {
  stage('3- RÃ©cupÃ©ration des crÃ©dentials'){
    withCredentials([
      usernamePassword(
          credentialsId: 'github_account',
          usernameVariable: "DEMO_USERNAME",
          passwordVariable: "DEMO_TOKEN"
      ),
      file(
        credentialsId: 'demo_file',
        variable: 'SECRET_FILE')
    ]){

      // Affichage des variables :
      print "Username github " + DEMO_USERNAME
      print "Token github "+ DEMO_TOKEN
    }
  } // end withCredential, les variables ne sont plus accessibles aprÃ¨s
}
