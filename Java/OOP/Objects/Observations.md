## Java Objects — Observations

```java
public class Main {

	 int x = 5;

	public static void main(String[] args) {
		Main myObj1 = new Main();
		Main myObj2 = new Main();
		
		System.out.println(myObj1.x);
		System.out.println(myObj2.x);
	}

}
```
## Instance Variables — Behavior Across Objects

Each object (`myObj1` and `myObj2`) has its **own copy** of the instance variable `x`. This means:

```java
myObj1.x = 5;
myObj2.x = 5;
```

If you change the value of `x` in one object:

```java
myObj2.x = 25;
```

It **does not affect** the other object:

```java
System.out.println(myObj1.x); // Outputs: 5
System.out.println(myObj2.x); // Outputs: 25
```

### Key Observations

1. **Each object has its own state**

   * Instance variables are tied to the object, not the class.
   * Changing one object's variable does not change another's.

2. **Access requires an object**

   * You cannot modify an instance variable directly from a static context (like `main`) without referencing an object.

3. **Real-world analogy:**

   * Think of each object as a **separate bank account**.

     * `myObj1` = Alice’s account, `myObj2` = Bob’s account.
     * Changing Alice’s balance does **not** affect Bob’s balance.


---

### Problem

When I tried to increment `x` like this:

```java
x++;
```

I got this error:

```
non-static variable x cannot be referenced from a static context
```

This suggests that to modify `x`, I must make it `static`.

### The Confusing Part

`myObj1.x++` works **without** making `x` static.

---

## Explanation — Why This Happens

### 1. `main` is a **static method**

This line:

```java
public static void main(String[] args)
```

means:

* `main` belongs to the **class itself**, NOT to any object.
* So inside `main`, you can ONLY directly access **static** variables/methods.

---

## Why does `x++` fail?

`x` is declared like this:

```java
int x = 5; // <-- NOT static (instance variable)
```

This means every object gets its **own** version of `x`.

When you write simply:

```java
x++;
```

Java thinks you're trying to access it **from the class**, because you’re inside a static method — but `x` is not static.

So you get:

```
non-static variable x cannot be referenced from a static context
```

Because you are trying to do something like:

```java
Main.x++; // but x isn't static
```

---

### 2. Why does `myObj1.x++` work then?

Because you're now accessing `x` through an **object instance**:

```java
myObj1.x++;
```

This means:

* You created an object: `new Main()`
* That object contains its own `x`
* You are modifying **that object's** `x`, not the class's `x`

So this is allowed.

Each object has its own separate copy:

```
myObj1.x = 5
myObj2.x = 5
```

Modifying `myObj1.x` only affects that object.

---

## Summary

### `x++` → NOT allowed

Because `main` is static, and `x` is **not** static.

### `myObj1.x++` → Allowed

Because you are modifying `x` through an **instance**, not a class.

---

## Should you make `x` static?

Only if your intention is:

* The value of `x` should be the **same shared value** for all objects.

Example:

```java
static int x = 5;
```

Then:

```java
Main.x++;  // valid
myObj1.x++; // also valid, but modifies the shared value
```

But normally, instance variables SHOULD NOT be static unless they are meant to be shared.

---

