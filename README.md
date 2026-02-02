# N-Queens Problem Simulation in Java (Backtracking)

## Overview

This project simulates the classic **N-Queens problem** using **recursion and backtracking** in Java.

**Goal:** Place **N queens** on an **N × N chessboard** such that no two queens attack each other.

A queen can attack another queen if they share the same:

* Row
* Column
* Diagonal

This implementation places queens **row by row** and uses a safety check before each placement.

---

## Core Idea of the Algorithm

The solution uses a **Backtracking approach**:

1. Start from the first row.
2. Try placing a queen in each column of that row.
3. Check if it is safe.
4. If safe → place the queen → move to the next row (recursion).
5. If stuck → remove the queen (backtrack) → try the next column.
6. Continue until all queens are placed.

---

## Board Representation

```java
int[][] board;
```

* `0` → Empty cell
* `1` → Queen placed

---

## Class Breakdown

### `NQueens` (Main Class)

Holds:

* Board size `N`
* Chess board array
* All logic methods

---

## Constructor

```java
public NQueens(int N)
```

**Purpose:**
Initializes the board with given size.

**What it does:**

* Stores the value of `N`
* Creates an empty `N × N` board

---

## Method: `isSafe(int row, int col)`

**Purpose:**
Checks whether a queen can be placed at `(row, col)`.

**Why only check upward?**
Because queens are placed row by row from top to bottom.

**Checks performed:**

1. **Column Check**

   ```java
   for (int i = 0; i < row; i++)
   ```

2. **Upper Left Diagonal**

   ```java
   for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
   ```

3. **Upper Right Diagonal**

   ```java
   for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
   ```

**Returns:** `true` if safe, otherwise `false`.

---

## Method: `solve(int row)`

**Purpose:**
Recursive backtracking function that tries to place queens row by row.

**Logic:**

```text
If row == N → All queens placed → print solution

For each column in the row:
    If safe:
        Place queen
        Recur for next row
        Remove queen (backtrack)
```

**Key Concept:** Backtracking after recursion.

**Returns:** `true` if at least one solution is found.

---

## Method: `printBoard()`

**Purpose:**
Displays the board in a readable format.

* `Q` → Queen
* `.` → Empty cell

---

## `main()` Method

```java
public static void main(String[] args)
```

**Purpose:** Entry point of the program.

**Steps:**

1. Set value of `N`
2. Create object of `NQueens`
3. Call `solve(0)` to start from first row

---

## 🧪 Sample Output (N = 4)

```
. Q . .
. . . Q
Q . . .
. . Q .
```

---

## Concepts Demonstrated

* Recursion
* Backtracking
* 2D Arrays
* Constraint Checking
* Problem Decomposition

---

## Possible Enhancements

* Take `N` as user input
* Count total number of solutions
* Visual GUI using Java Swing
* Step-by-step visualization

---

## Learning Outcome

After completing this project, what learning is obtained :

* How backtracking works
* How recursive decision trees are built
* How to manage state during recursion
* How constraint-based problems are solved

---

**Language:** Java
**Concepts:** Recursion, Backtracking, 2D Arrays, Algorithms
