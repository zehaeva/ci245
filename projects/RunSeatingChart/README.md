# Midterm Project: Angry Cousins
Congratulations! You are getting married! And your family hates everybody else in your family.  Awesome.  Now you get to make a seating chart for your reception.

## Problem Statement

Given the number of guests at the wedding, the number of people who can sit at each table, and a mapping of who hates who determine the minimum number of tables you'll need to seat the guests such that your reception will not end in a fist fight.  Tables may be partially filled.

## Points

Every single thing in this project overview is worth points down to the most minute details.  Read it carefully and follow all instructions.

## Partners

At your option you may work in groups of two. Please turn in only one assignment per group and be sure both of your names are on it.  It is HIGHLY recommended you work with a partner, but that is your choice.

## Sample File

The first line of the file will state the number of guests.  The second line will state the number of people who can be seated at a single table.  The third through last line will state who hates who.  The following example file should be read as there are 24 guests, up to 7 people may be seated at a single table, guests 1 and 6 hate each other, guests 7 and 15 hate each other, 13 and 17 hate each other, 9 and 23 hate each other, 10 and 21 hate each other, and 13 and 19 hate each other.

## Example File

24
7
1 6
7 15
13 17
9 23
10 21
13 19

## File Validation

Your program must validate the file before processing.  It must check the following requirements of the file.

That the file exists and can be read from.
That the first line of the file is a single value that can be interpreted as an integer. The value must be between 10 and 200.  This first line must exist.
That the second line of the file is a single value that can be interpreted as an integer.  The value must be 5, 6, 7, 8 or 100,000.  The second line must exist.
That the third and following lines have exactly two integers on them, separated by spaces.  Both integers on each line must be valid guest numbers (i.e. between 1 and 200 inclusive, depending on the value of line 1).  These files are not required. It can be the case that nobody hates anybody.
Test File Generation

In homework #3 you were given a problem which should generate test cases for you.

## The Shell Code

You will be given several code files (attached).  You are only to modify the code in "SeatingChart.java" as instructed in the file's comments.  All other files are off-limits to modification.

No programmer is perfect, not even your instructor.  If you find a bug in the shell code please notify your instructor immediately!

## Graph Coloring

This problem is the classic NP-Complete problem called Graph Coloring.  For more information and possible algorithms to use as guidelines please see Wikipedia's page on Knapsack.

## External Code and Libraries

You may not use any library external to Java for this project.  A person should be able to run your code on a brand new PC (or Mac) after installing eclipse and the Java framework and then opening your java files without installing any other programs.

You may copy code from the internet for trivial functions.  You must cite the source of the code in the comments.  You may not copy from the internet any complete or partial solutions of the Graph Coloring problem (which can go by many names).

## Comments and Coding Style

You must comment and style your code as we discussed in class.  Comments and style will be a large portion of your grade (around 20%).

## Grading

The project will be graded on a scale of 0 to 100 based on several criteria including whether you have met all of the requirements in this document and your commenting and style.

## Extra Credit

To receive extra credit your program must compute the correct results.  Extra credit will be awarded as follows:

Fastest Time: 10 pts
Second Fastest Time: 5 pts
Third Fastest Time: 3 pts
Beating the Instructor's Time: 2 pts
You can receive extra credit points in only one of the categories above.  To participate in the extra credit you must turn in your project before class on November 10, 2016.

## Turning Your Project In

To turn in your project place ONLY your java source files (they end in .java) in a zip file and email the zip file to jcovey (at) mvcc (dot) edu.
