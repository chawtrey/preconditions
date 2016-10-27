# Preconditions #

A simple library to make the testing of values easier to write and easier to read. Inspired by
[Google's Guava Preconditions](https://github.com/google/guava/wiki/PreconditionsExplained) and
Apache Common Validate (lang3).

## Overview ##

The preconditions library provides two classes: `Validate` and `Assure`.
The main difference between this library and Guava's Preconditions and Apache's Validate library is 
that all methods return the reference object being tested. 
This allows you to assign a `local` variable with a validated parameter.

## Validate ##

The `Validate` class provides a series of static validation methods. 
If the validation fails then an exception is thrown.

### Usage ###

```java
    public class MyClass {
        private final String aString;
        private final int anInt;
        private final List<String> aList;
        private final MyDao myDao = new MyDao();

        // Use pre-checks in validating constructor arguments
        public MyClass(String aString, int anInt, List<String> aList) {
            this.aString = Validate.notNull(aString, "String cannot be NULL");
            this.anInt = Validate.positiveOrZero(anInt, "int must be positive or zero");
            this.aList = Validate.notEmpty(aList, "List cannot be empty");
        }

        // Use pre-checks to validate Objects returned from other classes
        public MyBean fetchMyBeanById(String id) {
            return Validate.notNull(myDao.fetchById(
                Validate.notBlank(id, "ID must be valid"), "No bean found for ID = (%s)", id));
        }
    }
```

**NOTE:** within the `fetchMyBeanById` method, a validation is embedded within a method call. 
This can be done because all methods within `Validate` return the reference object being validated.

## Assure ##

The `Assure` class provides a series of static validation methods similar to those in the `Validate` class.
However, the `Assure` methods do not throw exceptions, but rather return a default or "corrected" value if the validation fails.

### Usage ###

```java
    public class MyClass {
        private final String aString;
        private final int anInt;
        private final LinkedList<String> aLinkedList;
        private final MyDao myDao = new MyDao();

        // Use assurances in validating constructor arguments
        public MyClass(String aString, Integer anInteger, List<String> aList) {
            this.aString = Assure.trimmedOrBlank(aString);
            this.anInt = Assure.notNull(anInteger, 10);
            this.aLinkedList = Assure.linkedList(aList);
        }

        // Use assurances to validate Objects returned from other classes
        public MyBean fetchMyBeanById(String id) {
            return Assure.notNull(myDao.fetchById(
                Assure.longValue(id, 123L), MyBean.class));
        }
    }
```
