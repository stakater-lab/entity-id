
## Postgres

To start a postgresql database in a docker container, run:

```
docker-compose -f src/main/docker/postgres.yaml up -d
```

To stop it and remove the container, run:

```
docker-compose -f src/main/docker/postgres.yaml down
```

## Features

- Entity Id is generated before saving the entity in the database; so, that always a valid/complete entity is created!