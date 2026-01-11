## WHEN VARIABLES SHOULD *NOT* BE STATIC

(Each object needs its own individual data → instance variable)

### Example 1 — A Person object

```java
class Person {
    String name;
    int age;
}
```

Why not static?

* Every person has their **own** name.
* Their own age.
* Their own height, weight, etc.

If these were static:

* Every person would have the same name and age → makes no sense.

---

### Example 2 — A Car object

```java
class Car {
    String model;
    int speed;
}
```

Why not static?

* Each car model may be different.
* Each car travels at its own speed.

If `speed` was static:

* When one car accelerates, ALL cars accelerate → unrealistic.

---

### Example 3 — A Student

```java
class Student {
    int grade;
    double marks;
}
```

Why not static?

* Each student has their own grade.
* Each student has their own exam marks.

---

>**Summary: Do NOT use static when the variable describes **the object itself****.

Examples: name, age, speed, color, size, position, health, score (in games), etc.

---

## WHEN VARIABLES *SHOULD* BE STATIC

(shared across all objects → belongs to the class)

Static variables represent **global properties**, not tied to one specific object.

---

### Example 1 — Counting how many objects exist

```java
class Car {
    static int carCount = 0;

    Car() {
        carCount++;
    }
}
```

Why static?

* You want to count ALL cars created.
* Every car contributes to the same shared counter.

---

### Example 2 — Global app settings

```java
class Settings {
    static boolean darkMode = true;
}
```

Why static?

* Dark mode is a setting for the whole program.
* Not per-user object.

---

### Example 3 — Math constants

```java
class MathHelper {
    static final double PI = 3.14159;
}
```

Why static?

* PI never changes.
* Every part of your program uses the same value.
* It doesn’t belong to any instance.

---

### Example 4 — Shared game difficulty

```java
class Game {
    static int difficulty = 1; // 1 = Easy, 2 = Medium, 3 = Hard
}
```

Why static?

* Difficulty level is for the WHOLE game, not per enemy or per player.

---

### Example 5 — Database connection

```java
class Database {
    static Connection connection;
}
```

Why static?

* You want **one shared connection**, not one per object.
* Otherwise, it wastes resources.

---

## Quick Summary Table


| Scenario               | Variable     | Should be static? | Why                           |
| ---------------------- | ------------ | ----------------- | ----------------------------- |
| Person's name          | `name`       | ❌ No              | Each person is unique         |
| Person's age           | `age`        | ❌ No              | Each person ages individually |
| Car's speed            | `speed`      | ❌ No              | Each car moves differently    |
| Number of cars created | `carCount`   | ✔ Yes             | One counter for all cars      |
| Global app setting     | `darkMode`   | ✔ Yes             | One setting for whole program |
| Math constant          | `PI`         | ✔ Yes             | Shared, does not change       |
| Game difficulty        | `difficulty` | ✔ Yes             | Whole game shares it          |

---

