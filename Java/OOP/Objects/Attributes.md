## Java Class Attributes — Expanded Notes With Comments

In the previous chapter, we used the term **"variable"** when storing values in a class.
But in Object-Oriented Programming (OOP), these variables are actually called **attributes** or **fields**.

An **attribute** is simply a variable that **belongs to a class**.

---

## Creating a Class With Attributes

Here is a class called `Main` with two attributes, `x` and `y`:

```java
public class Main {

  // These are attributes (also called fields)
  int x = 5;   // Attribute with initial value 5
  int y = 3;   // Attribute with initial value 3
}
```

✔ Attributes store data for each object created from the class.
✔ Each object will get its **own copy** of these values.

---

## Accessing Attributes

To access attributes, you must:

1. **Create an object** of the class
2. Use **dot syntax (`objectName.attributeName`)**

Example:

```java
public class Main {
  int x = 5;   // Attribute

  public static void main(String[] args) {

    // Create an object of the Main class
    Main myObj = new Main();

    // Access the attribute x from the object
    System.out.println(myObj.x);   // Prints: 5
  }
}
```

✔ The object (`myObj`) contains the variable `x`.
✔ `myObj.x` literally means “the x that belongs to myObj”.

---

## Modifying Attributes

You can change the value of an attribute **after** the object is created.

### Example: Assign a new value to `x`

```java
public class Main {
  int x;   // x has no value yet (default = 0)

  public static void main(String[] args) {

    Main myObj = new Main();

    myObj.x = 40;   // Change x using the object
    System.out.println(myObj.x);  // Prints: 40
  }
}
```

Notice: since `x` had no initial value, it starts at `0` until you change it.

---

### Example: Overriding an initial value

```java
public class Main {
  int x = 10;   // Initial value of x

  public static void main(String[] args) {

    Main myObj = new Main();

    myObj.x = 25;    // Change the value of x on THIS object only

    System.out.println(myObj.x);  // Prints: 25
  }
}
```

✔ The attribute changes only in the object you modify.
✔ Other objects still keep their own values.

---

## Preventing Changes With `final`

If you want an attribute to **never** be changed after initialization, use `final`.

```java
public class Main {
  final int x = 10;   // x becomes a constant

  public static void main(String[] args) {

    Main myObj = new Main();

    myObj.x = 25;  // ❌ ERROR: Cannot assign value to final variable

    System.out.println(myObj.x);
  }
}
```

✔ `final` makes the variable **read-only**.
✔ Useful for constants like `PI`, `gravity`, `maxSpeed`, etc.

---

## Multiple Objects = Each Object Has Independent Attributes

Each object created from the class gets **its own copy** of each attribute.

Example:

```java
public class Main {
  int x = 5;

  public static void main(String[] args) {

    Main myObj1 = new Main(); // Object 1
    Main myObj2 = new Main(); // Object 2

    myObj2.x = 25;  // Change x only for myObj2

    System.out.println(myObj1.x);  // Output: 5
    System.out.println(myObj2.x);  // Output: 25
  }
}
```

✔ `myObj1` keeps its original `x = 5`
✔ `myObj2` has a different value for `x`

This is how **OOP models real life**:
Each object has its **own** data.

---

## Multiple Attributes Example

A class can have any number of attributes:

```java
public class Main {

  // Attributes representing basic information
  String fname = "John";
  String lname = "Doe";
  int age = 24;

  public static void main(String[] args) {

    Main myObj = new Main();  // Create object

    // Access multiple attributes
    System.out.println("Name: " + myObj.fname + " " + myObj.lname);
    System.out.println("Age: " + myObj.age);
  }
}
```

✔ This is similar to storing details about a person or user.
✔ Each object could represent a different person.

---

## Summary (Easy To Remember)

| Term                        | Meaning                                           |
| --------------------------- | ------------------------------------------------- |
| **Class attribute / field** | A variable inside a class                         |
| **Object**                  | A copy of the class with its own attribute values |
| **Dot syntax**              | `object.attribute`                                |
| **final**                   | Makes the attribute unchangeable                  |
| **Multiple objects**        | Each has its own independent attributes           |

---

