#!/bin/sh
while ! nc -z mysqldb 3306 ; do
    echo "Waiting for MySQL server to be available"
    sleep 2
done
