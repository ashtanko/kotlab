.PHONY: check run test lines md default jacoco
check:
	./gradlew spotlessApply spotlessCheck spotlessKotlin detekt ktlintCheck --profile --daemon

md:
	truncate -s0 README.md && cat config/main.md >> README.md && cat build/reports/detekt/detekt.md >> README.md

jacoco:
	cp -r build/reports/jacoco/test/html jacocoReport

default:
	make check && make md && make jacoco

run:
	./gradlew build

test:
	./gradlew test

lines:
	find . -name '*.kt' | xargs wc -l

.DEFAULT_GOAL := default
