# Design Patterns and Virtual Classroom Manager

## Overview
This repository demonstrates the implementation of key software design patterns in Java and a terminal-based Virtual Classroom Manager. The exercises cover behavioral, creational, and structural design patterns, as well as a practical real-world application in educational technology.

## Exercise 1: Software Design Patterns

This section includes six examples showcasing two behavioral, two creational, and two structural design patterns.

### 1. Behavioral Design Patterns
- **Observer Pattern**: Real-time notifications in a stock market tracking system.
- **Strategy Pattern**: Dynamic selection of algorithms for sorting data.

### 2. Creational Design Patterns
- **Factory Pattern**: Creation of different types of vehicles (car, bike, bus) based on user input.
- **Singleton Pattern**: A Logger system that ensures only one instance of the logger class is used throughout the application.

### 3. Structural Design Patterns
- **Adapter Pattern**: Media player application that adapts incompatible interfaces for MP3, MP4, and VLC formats.
- **Decorator Pattern**: Coffee shop system where dynamic add-ons (milk, sugar, caramel) are added to the basic coffee order.

## Exercise 2: Virtual Classroom Manager

### Problem Statement
You are developing the backend for an EdTech platform that hosts virtual classrooms. The Virtual Classroom Manager needs to handle class scheduling, student attendance, and assignment submissions. This terminal-based system allows users to manage classrooms and students interactively.

### Features Implemented:
1. **Classroom Management**: 
   - Add new classrooms
   - List existing classrooms
   - Remove classrooms
2. **Student Management**: 
   - Enroll students in classrooms
   - List students enrolled in each classroom
3. **Assignment Management**: 
   - Schedule assignments for a specific classroom
   - Submit assignments for students

### Console Commands:
1. **Add Classroom:**  
   `add_classroom <class_name>`  
   Example: `add_classroom Math101`  
   Output: `Classroom Math101 has been created.`

2. **Add Student:**  
   `add_student <student_id> <class_name>`  
   Example: `add_student 123 Math101`  
   Output: `Student 123 has been enrolled in Math101.`

3. **Schedule Assignment:**  
   `schedule_assignment <class_name> <assignment_details>`  
   Example: `schedule_assignment Math101 Homework 1`  
   Output: `Assignment for Math101 has been scheduled.`

4. **Submit Assignment:**  
   `submit_assignment <student_id> <class_name> <assignment_details>`  
   Example: `submit_assignment 123 Math101 Homework 1`  
   Output: `Assignment submitted by Student 123 in Math101.`

5. **List Classrooms:**  
   `list_classrooms`  
   Output: Lists all existing classrooms.

6. **List Students:**  
   `list_students <class_name>`  
   Example: `list_students Math101`  
   Output: Lists all students enrolled in Math101.

7. **Remove Classroom:**  
   `remove_classroom <class_name>`  
   Example: `remove_classroom Math101`  
   Output: `Classroom Math101 has been removed.`

8. **Exit Application:**  
   `exit`  
   Terminates the application.

```### Code Structure:
```The solution uses a **HashMap** to store classrooms and their associated data. Each classroom contains a list of students and assignments. Exception handling and validation are integrated for input errors and invalid operations.

### Sample Output:
```bash
Enter command:
add_classroom Math101
Classroom Math101 has been created.

Enter command:
add_student 123 Math101
Student 123 has been enrolled in Math101.

Enter command:
schedule_assignment Math101 Homework 1
Assignment for Math101 has been scheduled.

Enter command:
submit_assignment 123 Math101 Homework 1
Assignment submitted by Student 123 in Math101.

Enter command:
list_classrooms
Classrooms:
- Math101

Enter command:
list_students Math101
Students in Math101:
- 123

Enter command:
remove_classroom Math101
Classroom Math101 has been removed.

Enter command:
exit
Exiting...
