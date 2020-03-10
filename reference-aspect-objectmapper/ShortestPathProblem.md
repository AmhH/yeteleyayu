# Shortest Path Problem

Bob and Alice have teamed up on a game show. They won the first round, allowing them access to a maze with hidden gold. If Bob can collect all the gold coins and deliver them to Alice's position, they can split the gold. Bob can move North⇆South or East⇆West as long as he stays in the maze and the cell is not blocked. 

**The task is to determine the shortest path Bob can follow to collect all gold coins and deliver them to Alice. If it is not possible, return -1.**

 

There is an n × m array where each of the values ∈ {0, 1, 2} representing open, blocked and open with a gold coin. Alice's position is given as (x,y) = (row, column). Bob starts at the top left, at cell (0, 0).

 

For example, maze = [[0,2,1],[1,2,0],[1,0,0]] with Alice at (2,2) is represented as follows:

    0 2 1
    1 2 0
    1 0 0


![](example1.png)


Alice's position is marked with an F for Finish. Bob, starting at (0,0), has two paths to Alice of length 4.

 

## Function Description 

Complete the function `minMoves` in the editor below. The function must return the integer length of Bob's shortest path, or -1 if it's not possible.

`minMoves` has the following parameter(s):

    maze[maze[0][0],...maze[n-1][m-1]]:  a 2D array of integers

    x:  an integer denoting Alice's row coordinate

    y:  an integer denoting Alice's column coordinate

 

## Constraints

    1 ≤ n, m ≤ 100
    0 ≤ the number of coins ≤ 10
    1 ≤ x < n
    1 ≤ y < m
 

## Input Format
The first line contains an integer `n`, the numbers of rows in maze.

The second line contains an integer `m`, the number of columns in maze.

Each of the next `n` lines contains `m` space-separated integers that describe the cells of each row in maze.

The next line contains an integer `x`, the row number of destination.

The next line contains an integer, `y`, the column number of destination.

## Sample Case 0
### Sample Input 0

    3
    3
    0 2 0
    0 0 1
    1 1 1
    1
    1
### Sample Output 0
    2
### Explanation 0

![](explanation0.png)

The shortest path Bob can take is (0, 0) → (0, 1) → (1, 1).

## Sample Case 1
### Sample Input 1

    3
    3
    0 1 0
    1 0 1
    0 2 2
    1
    1
### Sample Output 1

    -1
### Explanation 1

![](explanation1.png)

It is not possible for Bob to reach Alice, so return −1.

## Sample Case 2
### Sample Input 2

    3
    3
    0 2 0
    1 1 2
    1 0 0
    2
    1
### Sample Output 2

    5
### Explanation 2

![](explanation2.png)

The shortest path Bob can take is (0, 0) → (0, 1) → (0, 2) → (1, 2) → (2, 2) → (2, 1).