# Technical Questions

#### 1. What is Object Oriented Programming?

Object Oriented Programming is the practice of separating out 'units' of logic and state into individual self-standing objects. Objects can encapsulate their own state and data, as well as declaring the interface in which they can be queried and commanded to perform certain actions on their encapsulated state.

This is largely handled through method calls on an instantiated class, but there are many names for this concept with only minor differences. Some language refer to method calls from external call sites as passing messages to a given object.

#### 2. What are the main concepts of OOPs in Java?

There are a number of basic OO principles that are held in Java. These are:

- Data Encapsulation

    Data (and data processing methods) can be hidden from the outside world by controlling their visibility. Typically this is handled through the `public` and `private` keywords, where public data is explicity available to callers within that process, and private data is held and managed only by the object holding (encapsulating) that data.

- Data Abstraction

    Although related to encapsulation, abstraction is the process of ensuring that the implementation detail of internal processing of data within an object isn't exposed to the outside world. The object exposes method sigratures that must be adhered to, but their implementation is only the concern of the object being called. This saves on duplication of implementation detail.

- Object Inheritence

    Objects can act as children of other objects, and in doing so can take on the behaviours of their parent class. This can enable the re-use of logic among many common classes.

- Polymorphism

    By allowing child types to be swapped out (while still conforming to an expected interface) we are able to perform entirely different actions depending on the object being acted upon.

#### 3. Why Java is not 100% Object-oriented?

Although largely object oriented, Java can't claim to be 100% OO due to its use of primitive types. `short`, `int`, `long`, `float`, `double`, `boolean`, `byte`, and `char` are known as primitive types and are denoted by a lower case identifier. These are allocated into stack memory, whereas types denoted with a upper-case first letter are known as Reference types (described above as objects) and stored in heap-memory at runtime.

#### 4. Define class and object. Explain them with an example using java.

A class is the blueprint of an obect and defined how it behaves when passed certain messages. An object is an instance of the class and holds the specific data. One class can create many instances of itself.

This is a class, and acts as the blueprint for the behaviour of its instances:

```java
class TechTestUser {
    String firstName = "Jack";
    String lastName = "Turnbull";
    boolean passing;

    public TechTestUser(boolean passing) {
        this.passing = passing;
    }
}
```

This is an object created with that class:
```java
new TechTestUser(true);
```

#### 5. What is collection class in Java? List down its methods and interfaces

A collection class is a generic or concrete class that operates on an iterable.  It can iterate over a list of items and perform an action on the set.

[ArrayList](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/ArrayList.html) is one of the most popular collection classes, along with the generic [List<T>](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/List.html).

The [Collection](https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Collection.html) class itself (which is one common parent class of the above) provides a number of methods to its child classes:

- add(E e)
- addAll(Collection<? extends E> c)
- clear()
- contains(Object o)
- containsAll(Collection<?> c)
- equals(Object o)
- hashCode()
- isEmpty()
- iterator()
- parallelStream()
- remove(Object o)
- removeAll(Collection<?> c)
- removeIf(Predicate<? super E> filter)
- retainAll(Collection<?> c)
- size()
- spliterator()
- stream()
- toArray()
- toArray(IntFunction<T[]> generator)
- toArray(T[] a)

#### 6. What is final keyword in Java?

The final key word denoted that a field must not be changed after initialisation. The purpose of this is to make data fields within objects immutable and provide immutability guarantees.

#### 7. What is the difference between String s = "Test" and String s = new String("Test")? Which is better and why?

The first example would be equal to other strings declated with the value of "Test", whereas the second would not as this has created an object with the value of "Test" and placed that reference on the variable.

Because of this the second often leads to more side-effects and unexpected behaviour.

#### 8. What are the most important features introduced in Java 5, 7 and 8 respectively?

Java 5; Generics, enhanced for loop, typesafe enums.

Java 7; Diamond operator for generics, automatic resource management on block close, new file system API (NIO 2).

Java 8; Interface defaults, `Optional<T>`, stream API, lamda expressions.

#### 9. What’s the difference between unit, integration and functional testing?

Unit tests operate at the smallest unit of functionality; that is they attempt to interface with the closest public method and class to the implementation itself. An example of a unit test would be to check the specific behaviour of classes for given inputs.

Integrations tests ensure the correct function of multiple composed units at a higher level; they should check that units call and compose eachother correctly to produce an accurate 'bigger picture' result. An example of an integration test would be to perform a request against an API, and ensure the correct response data, status, and headers.

Functional testing is often at a much higher level - similar to that of the user. For a web facing application this could be achieved by simulating browser actions and ensuring that the page behaves and shows the correct data while performing real actions across the entire software stack.

You usually want to aim for more unit tests than integration tests, and more inteintegration tests than functional tests. This is known as the [test pyramid](https://martinfowler.com/articles/practical-test-pyramid.html).

#### 10. Define at least three types of Design Patterns in Java and provide an example for each.

##### Singleton Pattern

Ensure that the same instance of a class is used on every call site. This means all callers modify and operate on the same instance.

```java
class ExampleSingleton {
 
    private static ExampleSingleton instance = new ExampleSingleton();
 
    private ExampleSingleton() { }
 
    public static ExampleSingleton getInstance() {
        return instance;
    }
}
```

`getInstance` returns the singleton of self for every caller.

##### Factory Pattern

The factory pattern returns instantiated objects based on a static input.

```java
class UserFactory {
    User createTable(String type) {
        if (type.equals("admin")) {
            return new AdminUser();
        } else if (type.equals("editor")) {
            return new EditorUser();
        } else return null;
    }
}
```

##### Decorator Pattern

Set behavior on a single object rather than by class by chaining behaviours to that instance in a cascading manner.

```java
class UserDecorator implements User {
    private User user;
 
    public UserDecorator(User user) {
        this.user = user;
    }
 
    public String login() {
        return user.login();
    }
}

class User extends UserDecorator {
 
    public AdminUser(User user) {
        super(user);
    }
 
    public String login() {
        return super.login();
    }
}

class AdminUser extends UserDecorator {
 
    public AdminUser(User user) {
        super(user);
    }
 
 
    public String setPermission() {
        return "Setting permissions";
    }
 
    public String login() {
        return super.login() + " " + setPermissions();
    }
}

public class Login {
 
    public static void main(string[] args) {
        User user = new AdminUser(new User());
        System.out.println(user.login());
    }
}
```

#### 11. Explain how you would ensure that your web design is user-friendly and what kinds of steps would you use?

At a high level, it is crucial to understand the user needs and who a typical user of your system is. Knowing that at a deeper level is key to ensuring you can reason with and make decisions on your design. In more practical terms, collecting feedback and monitoring user behaviour through user research sessions can yield positive results, alongside following common user design patterns that have already been established.

Accessibility should also be considered part of this and designing for good accessibility can lead towards better user-experience decisions across the board, if handled correctly.

#### 12. What's your process for addressing browser-specific rendering problems? Do you find that a certain browser is more challenging to work with than others?

It largely depends on the target market I'm addressing and their breakdown of browser usage, alongside the current user base and what browsers they currently use. I like to accomodate as many users as possible and not dictate their browser choices.

To do so you can use a combination of automatic JavaScript and CSS processors, e.g. Babel's [preset-env](https://babeljs.io/docs/en/babel-preset-env) and [postcss-preset-env](https://github.com/csstools/postcss-preset-env) with a set [browserslist](https://github.com/browserslist/browserslist) as this can take a way a lot of the manual labour from you.

Beyond that it is key to use VM's and real devices here to ensure look+feel on equivalent browsers. I have also used Browserstack to great effect in the past.

Any version of Internet Explorer tends to be the most challenging, although more recently desktop Safari can pose challenges too.

#### 13. Explain the difference between cookies, session storage, and local storage?

Cookies and LocalStorage contain some overlap, but a key difference is that cookies are meant to be written and read on the server (set using the Cookie header), and are send back to the server on every request. LocalStorage is mainly used for consumption of local state only meant for the client side application.

SessionStorage maintains the same interface as LocalStorage but will be cleared at the end of the browser session.

#### 14. What is a Closure in Javascript?

An inline function, most recently denoted with the ES6 syntax `() => {}`

#### 15. Which among the Javascript libraries (React, Angular, etc.) would you prefer to work with? Provide pro’s and con’s of using it over others.

I prefer to work with React and have found its component based approach to be highly representative of team-based working patterns, and the encapsuation of logic it provides can assist re-use of code to a high degree. Beyond that there is a large ecosystem that has grown around React that is self-sustaining and can help developers of all levels upskill. I likely don't have time to go into a detailed comparison here, but this is something I do care about and would be keen to help any standardisation effort.
