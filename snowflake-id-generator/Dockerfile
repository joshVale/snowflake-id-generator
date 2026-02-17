# -----------------------
# Build stage
# -----------------------
FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app

# Настройки Gradle для TLS
ENV GRADLE_OPTS="-Dhttps.protocols=TLSv1.2,TLSv1.3"

# Копируем необходимые Gradle файлы и скрипты
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle gradle

# Скачивание зависимостей (кешируем)
RUN ./gradlew dependencies || return 0

# Копируем исходники
COPY src src

# Сборка проекта, исключая тесты и проверки ktlint
RUN ./gradlew clean build -x test \
    -x ktlintKotlinScriptCheck \
    -x ktlintMainSourceSetCheck \
    -x ktlintTestSourceSetCheck

# -----------------------
# Runtime stage
# -----------------------
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Создаём непривилегированного пользователя
RUN useradd --system --create-home --uid 1001 appuser
USER appuser

# Копируем собранный jar из build stage
COPY --chown=appuser:appuser --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

# Экспонируем порт приложения (Spring Boot по умолчанию 8080)
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
