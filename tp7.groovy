node {

  stage('Gestion erreur'){
    
    def affiche (string arg1) {
      println $arg1
    }

    println "Commande avant le try/catch"
    try {

      println "Commande pouvant générer une erreur"
      def number = env.BUILD_NUMBER as Integer

      if (number%2) {
        affiche ("Number " + number +  " is impair")
        // levee une exception
        throw new Exception()
      }
      else { println "Number "+ number +" is PAIR" }

    } catch (Exception e) {
        affiche ("FAIL : la commande échoue, traiter ce cas")
    } finally {
        affiche ("Commande toujours exécutée")
    }
  }

  stage('End'){ println 'END'}
}

