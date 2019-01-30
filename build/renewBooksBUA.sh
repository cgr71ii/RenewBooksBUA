#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

source $DIR/credentials.sh

echo "----------------------------------------------------------"
echo "|                     Renew Books BUA                    |"
echo "|                     ---------------                    |"
echo "|  Remember to Configure your Account in credentials.sh  |"
echo "----------------------------------------------------------"
echo "Executing..."
java -jar $DIR/RenewBooksBUA.jar --username $USERNAME_BUA --password $PASSWORD_BUA
