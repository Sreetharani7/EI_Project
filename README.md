# EI Java Projects - Design Patterns and Mini-Project

## Company: Educational Initiatives (EI)

This repository contains Java projects developed as part of the **EI Training Exercises**.  
The focus of these exercises is on applying **OOP principles, SOLID design, and software design patterns** in console-based applications.

---


---

## 📝 Exercise 1: Design Patterns

**Goal:** Demonstrate understanding of **behavioural, creational, and structural design patterns** through practical examples.  

**Implemented Patterns:**

| Pattern Type | Pattern       | Use Case Example                        |
|--------------|---------------|----------------------------------------|
| Behavioural  | Observer      | YouTube Channel subscription notifications |
| Behavioural  | Strategy      | Payment strategy selection in a Beauty Parlour |
| Creational   | Singleton     | Database Connection Manager             |
| Creational   | Factory       | Beauty Parlour Services creation        |
| Structural   | Decorator     | Skin Care Service Customization         |
| Structural   | Adapter       | Payment Gateway (PayPal / Stripe)      |

**Key Features:**

- Menu-driven console applications
- Input validation and exception handling
- Logging of all critical actions
- Observer pattern used for notifications
- No hard-coded loops or flags; long-running input supported
- Professional code structure (one class per file, consistent naming)


---

## 📝 Exercise 2: Astronaut Daily Schedule Organizer

**Goal:** Build a **console-based CRUD application** to manage astronauts’ daily tasks efficiently.  

**Design Patterns Used:**

- **Singleton:** `ScheduleManager` ensures one central task manager.  
- **Factory:** `TaskFactory` creates Task objects.  
- **Observer:** Notifies user when tasks overlap.

**Functionalities:**

- Add, remove, view tasks (mandatory)
- Optional: Edit tasks, mark tasks as completed
- Conflict detection with notifications
- Sorted task listing by start time
- Time validation to prevent invalid inputs

## ⚡ Features & Best Practices

- Console-based, no GUI required
- Modular, maintainable code with **SOLID principles**
- Logging mechanism for all actions
- Defensive programming and input validations
- Optimized for performance
- Well-organized project structure for scalability


