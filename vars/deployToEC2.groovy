def call() {

    sshagent(['deploy-server-ssh']) {

        sh '''
        ssh -o StrictHostKeyChecking=no ec2-user@13.233.80.41 << 'EOF'

        aws ecr get-login-password --region ap-south-1 | \
        docker login --username AWS --password-stdin 405305209495.dkr.ecr.ap-south-1.amazonaws.com

        docker pull 405305209495.dkr.ecr.ap-south-1.amazonaws.com/platform-control-service:v1

        docker stop platform-control-service || true

        docker rm platform-control-service || true

        docker run -d \
            --name platform-control-service \
            -p 80:80 \
            405305209495.dkr.ecr.ap-south-1.amazonaws.com/platform-control-service:v1

        EOF
        '''

    }

}
