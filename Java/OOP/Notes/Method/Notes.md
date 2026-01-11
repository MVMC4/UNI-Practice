## Java Class Methods — Expanded Notes With Detailed Comments

In Java, **methods** are blocks of code inside a class that perform actions.
You “call” a method when you want that action to happen.

---

## Creating a Method

Example: Create a method named `myMethod()` inside the `Main` class.

```java
public class Main {

  // A static method called myMethod
  // "static" means it belongs to the class, not an object
  static void myMethod() {
    System.out.println("Hello World!");   // This is the action
  }
}
```

✔ A method is basically a function inside a class.
✔ This method prints “Hello World!” when called.

---

## Calling a Method

To call a method, you write:

```
methodName();
```

Example: Call `myMethod()` inside `main()`:

```java
public class Main {

  static void myMethod() {
    System.out.println("Hello World!");
  }

  public static void main(String[] args) {

    // Call the method
    myMethod();   // This triggers the code inside myMethod()
  }
}

// Output:
// Hello World!
```

✔ You must use parentheses `()` even if the method has no parameters.
✔ Don’t forget the semicolon `;`.

---

## Accessing Methods With an Object

When a method is **not static**, you must create an object to use it.

Example:

```java
// Create a Main class
public class Main {

  // A method that prints a message
  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  // A method with a parameter
  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }

  public static void main(String[] args) {

    // Create an object of the Main class
    Main myCar = new Main();

    // Call methods using the object
    myCar.fullThrottle();
    myCar.speed(200);
  }
}
```

### Output:

```
The car is going as fast as it can!
Max speed is: 200
```

---

## Example Explained Step-by-Step

### 1. We created a **class** named `Main`.

Classes are templates — like blueprints — for creating objects.

---

### 2. Inside the class, we created two **methods**:

```java
public void fullThrottle() { ... }
public void speed(int maxSpeed) { ... }
```

✔ `fullThrottle()` prints a message.
✔ `speed()` prints a message **using a parameter** (`maxSpeed`).

---

### 3. Both methods perform actions when called:

* `fullThrottle()` → prints a sentence
* `speed()` → prints the car’s max speed

---

### 4. The method `speed()` accepts an `int` parameter:

```java
public void speed(int maxSpeed)
```

This is how Java allows a method to receive information from the outside world.

---

### 5. To use the methods, we must create an object of the `Main` class:

```java
Main myCar = new Main();
```

✔ `myCar` now contains the methods from the `Main` class.

---

### 6. The `main()` method runs automatically when the program starts.

Any code inside `main()` gets executed first.

---

### 7. We used the **`new`** keyword to create an object:

```java
Main myCar = new Main();
```

✔ `myCar` is now ready to use.

---

### 8. We called the methods using the object + dot:

```java
myCar.fullThrottle();
myCar.speed(200);
```

✔ The dot (`.`) allows access to:

* attributes
* methods

`myCar.speed(200);` passes the value `200` into the method.

---

## Important Things to Remember

✔ **Dot syntax (`.`)** is used to access object methods and attributes.
✔ A **method call** ends with `();`
✔ Methods can:

* have no parameters
* have one parameter
* have multiple parameters
  ✔ Methods can be:
* **static** → called without an object
* **non-static** → require an object

---

## Using Multiple Classes

It is good practice to separate your classes into different files.

You can create:

* **Main.java**
* **Second.java**

Example:

### Main.java

```java
public class Main {
  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }
}
```

### Second.java

```java
class Second {
  public static void main(String[] args) {

    Main myCar = new Main();   // Create object from Main class

    myCar.fullThrottle();      // Call method
    myCar.speed(200);          // Call method with parameter
  }
}
```

---

## How to Compile

```
javac Main.java
javac Second.java
java Second
```

Output:

```
The car is going as fast as it can!
Max speed is: 200
```

✔ The `Second` class runs `main()`
✔ It creates a `Main` object
✔ Then it uses the methods from the `Main` class

---

