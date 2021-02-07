.PHONY: check
check:
		./gradlew detekt ktlintCheck spotlessCheck spotlessApply --profile --daemon

.DEFAULT_GOAL := check
