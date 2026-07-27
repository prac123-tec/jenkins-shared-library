def call() {

    sh '''
    docker tag platform-control-service:v1 \
    405305209495.dkr.ecr.ap-south-1.amazonaws.com/platform-control-service:v1
    '''

}
