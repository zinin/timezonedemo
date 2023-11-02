#!/bin/bash
set -e

isDatabaseExist=`psql --host "$POSTGRES_HOST" --port "$POSTGRES_PORT" --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" -t -c "SELECT 1 FROM pg_database WHERE datname = 'tztestdb';"`
if [ -z "$isDatabaseExist" ]
then
  psql --host "$POSTGRES_HOST" --port "$POSTGRES_PORT" --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" -c "create database tztestdb;"
  echo "Database tztestdb created."
else
  echo "Database tztestdb already exists."
fi