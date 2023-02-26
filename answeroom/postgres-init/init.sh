#!/usr/bin/env bash
set -e

#
#  ВНИМАНИЕ!  Этот файл запускается только тогда,
#             когда папка volumes отсутствует при запуске docker-compose up
#

psql -v ON_ERROR_STOP=1 --username postgres --dbname postgres <<-EOSQL

    ALTER ROLE postgres WITH ENCRYPTED PASSWORD '111';

    CREATE USER answeroom WITH ENCRYPTED PASSWORD '111';
    CREATE DATABASE answeroom WITH OWNER answeroom;
    GRANT ALL ON DATABASE answeroom TO answeroom;

EOSQL
