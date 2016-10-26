# Preconditions #

A simple library to make the testing of values easier to write and easier to read. Inspired by
[Google's Guava Preconditions](https://github.com/google/guava/wiki/PreconditionsExplained).

## Overview ##

The preconditions library provides two classes: `PreChecks` and `Assurances`.
The main difference between this library and Guava's Preconditions library is that all methods return the reference object
being tested. This allows you to assign a `local` variable with a validated parameter.

## PreChecks ##

The `PreChecks` class provides a series of static validation methods. If the validation fails then an exception is thrown.

### Usage ###

```java
    public class MyClass
        private final String aString;
        private final int anInt;
        private final List<String> aList;
        private final MyDao myDao = new MyDao();

        // Use pre-checks in validating constructor arguments
        public MyClass(String aString, int anInt, List<String> aList) {
            this.aString = PreChecks.checkNotNull(aString, "String cannot be NULL");
            this.anInt = PreChecks.checkPositiveOrZero(anInt, "int must be positive or zero");
            this.aList = PreChecks.checkNotEmpty(aList, "List cannot be empty");
        }

        // Use pre-checks to validate Objects returned from other classes
        public MyBean fetchMyBeanById(String id) {
            return PreChecks.checkNotNull(myDao.fetchById(
                PreCheck.checkNotBlank(id, "ID must be valid"), "No bean found for ID = (%s)", id);
        }
    }
```

**NOTE:** within the `fetchMyBeanById` method, a pre-check is embedded within a method call. This can be done because all
pre-checks return the reference object being validated.

## Assurances ##

The `Assurances` class provides a series of static validation methods similar to those in the `PreChecks` class.
However, the `Assurances` methods do not throw exceptions, but rather return a default or "corrected" value.

### Usage ###

```java
    public class MyClass
        private final String aString;
        private final int anInt;
        private final LinkedList<String> aLinkedList;
        private final MyDao myDao = new MyDao();

        // Use assurances in validating constructor arguments
        public MyClass(String aString, Integer anInteger, List<String> aList) {
            this.aString = Assurances.assureTrimOrBlank(aString);
            this.anInt = Assurances.assureNotNull(anInteger, 10);
            this.aLinkedList = Assurances.assureLinkedList(aList);
        }

        // Use assurances to validate Objects returned from other classes
        public MyBean fetchMyBeanById(String id) {
            return Assurances.assureNotNull(myDao.fetchById(
                Assurances.assureLong(id, 123L), MyBean.class);
        }
    }
```
