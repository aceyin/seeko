#!/bin/sh
#### Check Java
JAVA=`which java`
if [[ 'x'${JAVA} == 'x' ]]; then
    echo "No Java found in system, please install Java first.";
    exit 1;
fi

#### Check the SEEKO_HOME
USER_HOME="${HOME}";
if [[ 'x'${USER_HOME} == 'x' ]]; then
    USER_HOME="eval echo ~${USER}";
    if [[ 'x'${USER_HOME} == 'x' ]]; then
        USER_HOME="`ls -d ~`";
    fi
fi
SEEKO_HOME="${USER_HOME}/.seeko";

#### Create directory if not exist
if [[ ! -d ${SEEKO_HOME} ]]; then
    `mkdir ${SEEKO_HOME}`
fi


#### Main CLI Jar
CLI="${PWD}/lib/cli.jar";

#### Set classpath
CLASSPATH=".:${CLASSPATH}:${PWD}/lib/cli.jar:${PWD}/lib/args4j-2.0.26.jar";

#### JAVA_OPT
JAVA_OPT="-D SEEKO_HOME=${SEEKO_HOME}"

`${JAVA} -jar ${CLI} -cp ${CLASSPATH} ${JAVA_OPT}`
