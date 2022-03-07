
# $ make <command>

# Creates Docker image
dockerBuild:
	docker build -f Dockerfile -t springbootrestapi-0.0.1 .

dockerScan:
	docker scan -f Dockerfile springbootrestapi-0.0.1

# To run the Docker image
dockerRun:
	docker run -p 8080:8080 springbootrestapi-0.0.1


# **********************************************************************
# How to Setup Docker Containers as Build Agents for Jenkins

# docker-compose build
docComposeBuild:
	docker-compose -f docker-compose.restapi.yml build

# docker-compose up
docComposeUp:
	docker-compose -f docker-compose.restapi.yml up

# docker-compose start
docComposeStart:
	docker-compose -f docker-compose.restapi.yml start

# docker-compose stop
docComposeStop:
	docker-compose -f docker-compose.restapi.yml stop

# docker-compose down
docComposeDown:
	docker-compose -f docker-compose.restapi.yml down