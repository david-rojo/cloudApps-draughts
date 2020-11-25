# **Draughts refactoring**

Read [documentation](../README.md) first please

### 1. Refactoring

The following refactors has been applied to the code:

- NullObject pattern to Color class.
- StarView, PlayView and ResumeView functionality moved to View class.
- Chain of responsability pattern applied to Movement Checker.
- Changed to Model View Presenter architectural pattern with Passive View approach.

### 2. Prerequisites
- [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/install.html)

### 3. Install

from current folder draughts:

```
$ mvn install
```

### 4. Usage

from current folder draughts:

```
$ mvn package
$ java -jar target/draughts-1.0-SNAPSHOT.jar
```

### 5. Run tests (JUnit5)

from current folder draughts:

```
$ mvn test
```

### Author

[David Rojo(@david-rojo)](https://github.com/david-rojo)

