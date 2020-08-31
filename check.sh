#!/bin/bash
sh gradlew detekt :app:detekt :server:detekt ktlintCheck :app:spotlessCheck
