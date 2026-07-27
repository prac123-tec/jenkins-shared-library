def call() {

    withCredentials([[
        $class: 'AmazonWebServicesCredentialsBinding',
        credentialsId: 'aws-ecr-creds'
    ]]) {

        sh '''
        aws ecr get-login-password --region ap-south-1 | \
        docker login --username AWS --password-stdin 405305209495.dkr.ecr.ap-south-1.amazonaws.com
        '''

    }
}
