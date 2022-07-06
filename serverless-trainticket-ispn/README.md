# Serverless TrainTicket - Infinispan

This is an open source microservice benchmark system. It is a train booking system based on the microservice architecture, including 41 kinds of microservices. The main development technology frameworks used are as follows:
- Java - OpenFaaS
- DB - Infinispan

## Quick Start

This project is based on a Kubernetes cluster and uses the open source functional computing framework OpenFaaS to deploy our Serverless TrainTicket system.
### Prerequisites

Since this project chooses Kubernetes to build the OpenFaaS serverless platform, you need at least two servers to build a Kubernetes cluster. [Cluster Deployment Tutorial](https://blog.csdn.net/lbw520/article/details/96446272)

#### Server System Requirements

- CPU and memory: dual core, more than 4GB.
- Operating system: Various Linux distributions based on x86_64, including CentOS, Federa, Ubuntu, etc., but the kernel requires 3.10 and above.
- Container runtime: Docker is generally used as the container runtime.

### 1. Log in to Docker Hub

```shell
docker login -u <username> -p <password>
````

### 2. Install OpenFaaS

#### 2.1 Install OpenFaaS on GCP

Create Kubernetes cluster on GCP
```shell
gcloud container clusters create mycluster --num-nodes=2 --machine-type=e2-standard-2 --zone europe-west1-b
````

Install faas-cli
```shell
curl -sL https://cli.openfaas.com | sudo sh # Linux
brew install faas-cli # MacOS
````

Get arkade MacOS / Linux:
```shell
curl -SLsf https://dl.get-arkade.dev/ | sudo sh
````

Install the OpenFaaS chart using arkade
```shell 
arkade install openfaas --load-balancer
PASSWORD=$(kubectl get secret -n openfaas basic-auth -o jsonpath="{.data.basic-auth-password}" | base64 --decode; echo)

kubectl get svc -n openfaas # Wait until you get the External IP of  GATEWAY

export OPENFAAS_URL="http://[YOUR OPENFAAS GATEWAY IP]:8080"
export OPENFAAS_PREFIX="[YOUR DOCKER REGISTRY URL]/[YOUR DOCKER REGISTRY USERRNAME]"
# eg: export OPENFAAS_PREFIX="docker.io/tmsquare"

echo $PASSWORD | faas-cli login --password-stdin
```
#### 2.2 Install OpenFaaS on minikube

Create namespaces for OpenFaaS
```shell
kubectl apply -f https://raw.githubusercontent.com/openfaas/faas-netes/master/namespaces.yml
````

Add the OpenFaaS helm repository
```shell
helm repo add openfaas https://openfaas.github.io/faas-netes/
helm repo update
````

Install OpenFaaS using the chart
```shell
helm upgrade openfaas --install openfaas/openfaas --namespace openfaas --set functionNamespace=openfaas-fn --set basic_auth=false
````

Set the OPENFAAS_URL env-var
```shell
export OPENFAAS_URL=$(minikube ip):31112
````

Finally login using the CLI
```shell
faas-cli login -g http://$OPENFAAS_URL -u admin
````


### 3. MASTER_ID & DOCKER_USERNAME variables required for deployment

Inside the files part01_DataBaseDeploymentISPN.sh and part02_FaaSFunctions.sh

```shell
MASTER_ID=<OPENFAAS_URL>
DOCKER_USERNAME=<docker_username>
````

### 5. Execute the database automatic deployment script file

```shell
chmod u+x part01_DataBaseDeployment.sh
./part01_DataBaseDeployment.sh
````

Run `kubectl get pods` and `kubectl get pods -n openfaas-fn` and wait for all database initialization function Pods to be Ready, then run the following command

```shell
# Initialize data content
chmod u+x part01_DataInitiation.sh
./part01_DataInitiation.sh
````

### 6. Execute the backend automatic deployment script file

```shell
# BaaS service deployment
chmod u+x part02_BaaSServices.sh
./part02_BaaSServices.sh
````

```shell
# FaaS function deployment
chmod u+x part02_FaaSFunctions.sh
./part02_FaaSFunctions.sh
````

### 7. Execute the front-end automatic deployment script file

```shell
# Front-end deployment
chmod u+x part03_Frontend.sh
./part03_Frontend.sh
````

### 8. Run `kubectl get pods --all-namespaces` and wait for all Pods to be Ready

### 9. Visit the Serverless TrainTicket home page http://[Node-IP]:32677