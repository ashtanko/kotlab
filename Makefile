.PHONY: check run test lines md default jacoco spotless

# Run detekt + ktlint
check:
	./gradlew detekt ktlintCheck --profile --daemon

# Run spotless, more info: https://github.com/diffplug/spotless
spotless:
	./gradlew spotlessApply spotlessCheck spotlessKotlin

# Update the README.md file in accordance with the detekt report
md:
	truncate -s0 README.md && cat config/main.md >> README.md && cat build/reports/detekt/detekt.md >> README.md

# Copy jacoco report
jacoco:
	cp -r build/reports/jacoco/test/html jacocoReport

# Run code style check + update the README.md file in accordance with the detekt report
default:
	make check && make md

# Build the project
run:
	./gradlew build

# Run tests
test:
	./gradlew test

# Print Kotlin lines count
lines:
	find . -name '*.kt' | xargs wc -l

.DEFAULT_GOAL := default
