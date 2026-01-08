# AGENTS.md

## 🤖 AI Agent Context & Instructions
This file serves as a guide for AI agents (like GitHub Copilot, Cursor, or Windsurf) to understand the technical stack, build processes, and contribution standards of this project.

---

## 🏗 Project Architecture
* **Runtime:** Java 21 (OpenJDK)
* **Build System:** Maven (using `./mvnw` wrapper)
* **Testing Framework:** JUnit 5 (Jupiter)
* **Containerization:** Docker (Multi-stage builds)



---

## 🛠 Operational Commands

### Development & Build
Agents should use the following commands to ensure environment parity:
* **Clean and Package:** `./mvnw clean package`
* **Run Locally:** `./mvnw exec:java -Dexec.mainClass="com.example.Main"`

### Testing
* **Execute All Tests:** `./mvnw test`
* **Run Specific Test:** `./mvnw -Dtest=ClassName test`
* **Coverage:** Ensure all new logic includes a corresponding JUnit test case in `src/test/java`.

### Dockerization
The project includes a `Dockerfile` for consistent deployment.
* **Build Image:** `docker build -t simple-java-app .`
* **Run Container:** `docker run -p 8080:8080 simple-java-app`

---

## 📝 Coding Standards & Rules

1.  **Java Patterns:** * Prefer `Records` for data transfer objects.
    * Use functional programming patterns (Streams, Optionals) where it improves readability.
2.  **Testing Strategy:**
    * Follow the **Given-When-Then** structure in test methods.
    * Use `@BeforeEach` to set up fresh state for every test.
3.  **Dependency Management:**
    * Always check `pom.xml` before suggesting new libraries to avoid version conflicts.

---

## 📂 Project Map
* `/src/main/java`: Application source code.
* `/src/test/java`: Unit and integration tests.
* `Dockerfile`: Defines the production runtime environment.
* `pom.xml`: Project configuration and dependencies.

---

## ⚠️ Constraints
* **Compatibility:** Do not use features beyond Java 21.
* **Performance:** Ensure Docker images remain small by using the `eclipse-temurin:21-jre-alpine` base for the final stage.