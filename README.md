# PCCCS495 – Term II Project

## Project Title
Hospital Appointment Management System
---

## Problem Statement (max 150 words)
Managing hospital appointments manually can be inefficient and time-consuming. Patients face delays and hospitals struggle to organize schedules. This system helps manage patients, doctors, and appointments efficiently using a console-based application.
---

## Target User
- Hospital staff
- Receptionists
- Patients (indirect use)
---

## Core Features
- Add and manage patients
- View doctors
- Book appointments
- View appointments
- Cancel appointments
---

## OOP Concepts Used
- Abstraction: Used in User base class to define common properties
- Inheritance: Patient extends User class
- Polymorphism: Method overriding used in different classes
- Encapsulation: Private variables with getters/setters
- Exception Handling: Used for input validation in Main class
- Collections: ArrayList used to store patients, doctors, appointments
---

## Proposed Architecture Description
The system is divided into multiple classes:
- User (base class)
- Patient
- Doctor
- Appointment
- HospitalManager
- Main (entry point)
---

## How to Run
1. Open terminal
2. Go to src folder:
   cd src
3. Compile:
   javac *.java
4. Run:
   java Main
---
