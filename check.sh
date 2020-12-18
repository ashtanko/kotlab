#!/bin/bash
sh gradlew detekt ktlintCheck spotlessCheck spotlessApply --profile
