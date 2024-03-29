#!/usr/bin/env bash
echo "Running static analysis..."

JAVA_HOME=$(/usr/libexec/java_home -v 11)
export JAVA_HOME

OUTPUT="/tmp/analysis-result"
./gradlew spotlessApply spotlessCheck spotlessKotlin detekt ktlintCheck --profile > ${OUTPUT}
EXIT_CODE=$?
if [ ${EXIT_CODE} -ne 0 ]; then
    cat ${OUTPUT}
    rm ${OUTPUT}
    echo "*********************************************"
    echo "            Static Analysis Failed           "
    echo "Please fix the above issues before committing"
    echo "*********************************************"
    exit ${EXIT_CODE}
else
    rm ${OUTPUT}
    echo "*********************************************"
    echo "      Static analysis no problems found      "
    echo "*********************************************"

    echo "*********************************************"
    echo "          Coping the detekt report           "
    echo "*********************************************"

    cat ../../build/reports/detekt/detekt.md >> README.md

    echo "*********************************************"
    echo "                   All set                   "
    echo "*********************************************"
fi
