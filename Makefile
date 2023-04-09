build:
	./gradlew build

test:
	docker-compose up -d
	./gradlew test
	docker-compose down
