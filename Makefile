.PHONY: build up down logs restart

up:
	docker compose -f docker/docker-compose.yml up -d
