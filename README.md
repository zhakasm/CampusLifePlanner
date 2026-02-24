# CampusLife Planner  
Java Object-Oriented Programming Project

## Project Description

CampusLife Planner is a small Java application designed to model basic aspects of university academic life using Object-Oriented Programming principles.

The system includes classes representing courses, assignments, and study sessions. The main program demonstrates object creation, interaction, and simple data analysis.

## Implemented Classes

### Course
Represents a university course with:
- name
- instructor
- credits

### AssignmentTask
Represents coursework linked to a course with:
- title
- estimated hours
- days until due
- completion status

Includes logic to:
- mark a task as completed
- determine if a task is urgent (due in ≤ 2 days)

### StudySession
Represents time spent studying for a course.
Includes conversion of minutes to hours.

### CampusLifeApp
Main driver class that:
- creates sample objects
- prints all courses and assignments
- highlights urgent tasks
- calculates total remaining workload
- calculates total study time per course
- updates assignment status and recalculates totals
