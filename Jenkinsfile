def my_variable="myvariable"

node {
    stage('First'){
        print "Hello"
        sh 'env'
    }
    
    stage('Second'){
        print 'Deux parties de la formation'
    }
    stage('print variable'){
        print "build number: $BUILD_NUMBER"   
    }
    stage('Print groovy variable'){
        print "Print groovy variable " + my_variable
        print "Print groovy variable  $my_variable"
    }
    stage('print param'){
        print "Parameter value " + params.param_string
    }
}
