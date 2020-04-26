mvn clean compile install
docker build -t vinothg2309/customer-service .
docker push vinothg2309/customer-service
kubectl delete -f customer-service.yaml
kubectl apply -f customer-service.yaml
