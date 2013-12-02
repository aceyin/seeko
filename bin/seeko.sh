#!/bin/sh
#
# System configurations
#
# The HTTP port of the seeko web module. Default is 8080
HTTP_PORT=8080
#
# The heap size of the seeko web module. Default is 512m.
HEAP_SIZE=512m
#
# The heap size for indexer module. Default is 1024m.
# The core functions of indexer module are:
# 1. checkout/clone the source codes from the remote repositories.
# 2. read and parse the source codes and submit the content to the elasticsearch module.
# 3. check the changes of the remote repositories regularly and submit the changes into elasticsearch module.
# Since the indexer module need to read and parse files, so the memory size will impact the performance of this module.
# Please set the heap size of indexer module to the corresponding value accordingly.
INDEXER_HEAP_SIZE=1024m
#
# The heap size of elasticsearch module. Default is 1024m.
# The elasticsearch module is the core module provides the full text search feature.
# The memory size will impact the performance of elasticsearch module.
# Please set the heap size of elasticsearch module to the corresponding value accordingly.
ES_HEAP_SIZE=1024m
#
# check Java
JAVA=`which java`
if [[ 'x'${JAVA} == 'x' ]]; then
    echo "No Java found in system path, please install Java first.";
    exit 1;
fi


# check the SEEKO_HOME
if [[ 'x'${SEEKO_HOME} == 'x' ]]; then
    SEEKO_HOME="`dirname $0`";
fi

# Check the SEEKO_DATA_DIR
USER_HOME="${HOME}";
if [[ 'x'${USER_HOME} == 'x' ]]; then
    USER_HOME="eval echo ~${USER}";
    if [[ 'x'${USER_HOME} == 'x' ]]; then
        USER_HOME="`ls -d ~`";
    fi
fi
SEEKO_DATA_DIR="${USER_HOME}/.seeko";

# Main CLI Jar
CLI="${SEEKO_HOME}/lib/cli.jar";

# Set classpath
CLASSPATH=".:${CLASSPATH}:${SEEKO_HOME}/lib/cli.jar";

# JAVA_OPT
JAVA_OPT="-Dseeko.home=${SEEKO_HOME} -Dseeko.data.dir=${SEEKO_DATA_DIR}"

`${JAVA} -jar ${CLI} -cp ${CLASSPATH} ${JAVA_OPT}`
