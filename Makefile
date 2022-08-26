.PHONY: check run test lines
check:
	./gradlew spotlessApply spotlessCheck spotlessKotlin detekt ktlintCheck --profile --daemon

run:
	./gradlew build

test:
	./gradlew test

lines:
	find . -name '*.kt' | xargs wc -l

.DEFAULT_GOAL := check
