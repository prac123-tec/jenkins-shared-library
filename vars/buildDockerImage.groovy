def call() {
    echo "Building Docker Image..."

    sh 'docker build -t platform-control-service:v1 .'
}
