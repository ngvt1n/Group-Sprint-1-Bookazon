# Group Sprint 1: Bookazon
An assignment for redesigning software and refactoring code smells.  Part of Software Engineering class CS321, fall 2024.

## Project Objectives
- Practice redesigning a software project with guidance from **SOLID design principles**.
- Refactor code to address **design smells** and enhance **readability** and **maintainability**.
- Apply **Agile Scrum** and **project management** fundamentals.
- Collaborate as a team using **Git** and **GitHub** effectively.

---

## Overview
In this project, you will work in small teams to **extend** and **improve** an existing online book store. The project focuses on adding new functionality while ensuring the system adheres to **key software design principles**. Throughout the project, you will practice collaborative development via GitHub, utilizing best practices such as **issue tracking**, **code reviews**, and **feature branching**.

---

## Repository Management
- The **repo manager** should begin by forking the project repository on GitHub and adding all team members as collaborators.  
  - **Starting Repository:** [Link to be provided]
- The forked repository will serve as your team's workspace. All progress will be tracked through GitHub.

---

## Class Diagram and Code Review
- Draw a **UML class diagram** to visualize the system's structure and component relationships.
- Have a group discussion on the current **design** and **code** to ensure all team members understand the system.
  
---

## SOLID Principles, Code Smells, and Technical Debt
- Identify **design problems** in the system that violate **SOLID principles**.
- Make a list of any **code smells** (e.g., duplicated code, long methods, or classes with too many responsibilities).
- Document each issue clearly, providing examples from the codebase.

---

## Propose Solutions and Create Issues
- Discuss potential solutions for each identified design problem and code smell.
- Add these problems as **issues** in your GitHub repository. Each issue should include:
  - A clear description of the problem (with references to the code).
  - The proposed solution (e.g., refactoring, code redesign, or applying SOLID principles).

---

## Adding New Features
- Extend the system's functionality by:
  - **Updating the order printing** to include discount details.
  - Expanding the system to support **new media types**: audiobooks, DVDs, and e-books.
- Plan the necessary design changes to incorporate these new features while maintaining SOLID principles.

---

## Milestone and Issue Organization
- The **backlog manager** is responsible for organizing identified issues into a **milestone**.
- Properly **label** each issue, indicating its type (e.g., "bug," "enhancement," "refactoring") and priority level.

---

## Teamwork and GitHub Practices
- Each team member should select **one issue** at a time to work on and may take on another only after completing the current one.
- Follow Git/GitHub practices by:
  - Creating a **feature branch** for each issue.
  - Ensuring that your branch doesn't break the system (test your changes).
  - **Opening a pull request (PR)** to merge your changes back into the main branch.
- **Code Reviews:** Each team member must review at least **one PR** from another member to ensure code quality and consistency.
- Keep the **main branch** in a working state at all times. No broken or unfinished code should be merged into the main branch.
- Ensure no **stale feature branches** remain after a milestone. Clean up unused branches.

---

## Extensions
- Fix all coding style issues with guidance from a tool such as **CheckStyle**. Document your progress with **before/after snapshots** of the code.
- Create a **burndown chart** for this sprint using GitHub or another tool.
- Add a **creative and elaborate `README.md`** file to your repository explaining the work you did. This should be more creative than the project report.

---

## Report (Google Doc)
Organize a **Google Doc report** with the following sections, including screenshots and text to communicate the objectives of your work:

1. **Abstract:**  
   A brief summary of the Sprint in your own words (no more than 150 words). Give context and summarize the outcome.

2. **Results:**  
   A section outlining the results of your Sprint, including links to your **public repository**.

3. **Reflection:**  
   Reflect on what you learned during the Sprint.

4. **Extensions:**  
   Describe any extensions you undertook, supported by text output, graphs, tables, or images.

5. **References/Acknowledgements/AI Use Documentation:**  
   List any references used and acknowledge AI tools, if applicable, that contributed to your work.

   -------------------------------------------------------------------------------------------------------------------------------------------

 ## Rishit Chatterjee
 
<p align="center">
  <em>“SOLID Code”</em>
</p>

<h1 align="center">Bookazon — Group Sprint 1</h1>
<p align="center">
  Pricing & Subscription refactor via small interfaces and strategies — no magic strings, no if/else pyramids.
</p>

---

## What this branch delivers
- Type-safe **subscriptions** (no raw strings) and a pure **pricing strategy**.
- `Order` now **depends on abstractions**: it computes a subtotal and delegates pricing.
- **Collections correctness**: `CartItem.equals(Object)/hashCode()` fixed; `Order` copies cart items defensively.
- Clean integration with the team’s **printing layer** (`Printer<T>`, `PrintManager`) and media model.

---

## Contributor Spotlight — @AgentQuantum (Rishit Chatterjee)
I authored the **Pricing & Subscription** redesign and the related **cart/order fixes** in this sprint.  
PR: **#14 — _Refactor: Pricing & Subscription via interfaces (+ cart/order fixes)_**

---

## What I Built (My Contribution)
- **`Subscription` interface** with concrete tiers: `NormalSubscription`, `SilverSubscription`, `GoldSubscription`, `PlatinumSubscription`.  
  → Eliminates magic strings and normalizes tier identity.
- **`PricingPolicy` strategy** with **`TablePricingPolicy`** (named constants; **double-dispatch overloads**).  
  → No `if/else`, no `switch`, no `Map` needed for selecting discounts.
- **`Order` integration**:  
  ```java
  public Order(Cart cart, Subscription sub, PricingPolicy policy) {
    this.items = new java.util.ArrayList<>(cart.getItems());
    double subtotal = 0.0;
    for (CartItem it : items) subtotal += it.getTotalPrice();
    this.orderPrice = sub.price(subtotal, policy);            // delegate
  }


-------------------------------------------------------------------------------------------------------------------------------------------

## Tenzin Thiley

<p align="center">
  Printer Interface, PrinterManager Class 
</p>

---

## Problems Addressed By These Classes 
- Eliminates *Feature Envy* from (`Book`, `User`, `Order`)



