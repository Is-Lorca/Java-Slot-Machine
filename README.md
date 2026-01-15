# Slot Machine Simulator 🎰

A simple and interactive **console-based Slot Machine game** written in Java.  
This project simulates a classic slot machine experience in the terminal, including balance management, betting, randomized spins, and a payout system, while practicing core Java programming concepts.

---

## 💻 Technologies Used

- Java
- `Scanner` class for user input
- `Random` class for symbol generation
- `ProcessBuilder` for console screen clearing
- Console output using `System.out.print` and `System.out.printf`
- Unicode emoji symbols for slot machine visuals
- Arrays for slot rows and symbol handling
- Basic exception handling (`IOException`, `InterruptedException`)

---

## 📚 Project Purpose

This project was developed to practice and reinforce:

- Programming logic
- Java syntax and structure
- Methods and return values
- Conditional statements (`if/else`, `switch`)
- Loops (`while`, `do/while`)
- User input validation
- Randomized behavior
- Arrays for data handling
- Console-based UI organization
- Simple game mechanics simulation

It is part of my personal Java learning portfolio and represents my progress in building interactive terminal-based games using Java.

---

## ▶️ How It Works

1. The program starts by displaying a welcome banner with the payout table.
2. The user is asked to enter an initial balance.
3. The game enters a loop where:
   - The current balance is shown.
   - The user enters a bet amount.
   - Invalid bets (zero, negative, or higher than balance) are rejected.
4. The screen is cleared for a cleaner experience.
5. The user presses any key to pull the slot machine lever.
6. Three random symbols are generated and displayed one by one.
7. The program checks for winning combinations:
   - Three matching symbols (triple)
   - Two matching symbols (double)
8. If the player wins, the payout is added to the balance.
9. The user can choose to play again or exit.
10. If the balance reaches zero, the user can choose to add more credit or quit.
11. When the game ends, a final balance and goodbye message are displayed.

---

## 📌 Features

- Classic slot machine gameplay
- Randomized symbol generation
- Multiple payout levels based on symbol combinations
- Balance and betting system
- Input validation for balance and bets
- Visual slot row display using Unicode emoji symbols
- Cross-platform console screen clearing:
  - Windows
  - Linux
  - macOS
- Clean and immersive terminal-based experience
- Simple, readable, and modular code structure

---

## 🎰 Payout System

Each symbol has different rewards depending on the combination:

- 🌩️
  - Double: 2× bet
  - Triple: 3× bet
- 🌧️
  - Double: 3× bet
  - Triple: 4× bet
- 🌦️
  - Double: 4× bet
  - Triple: 5× bet
- ⛅
  - Double: 5× bet
  - Triple: 10× bet
- ☀️
  - Double: 10× bet
  - Triple: 20× bet

---

## 🚀 How to Run

1. Make sure you have Java installed on your system.
2. Clone this repository.
3. Compile the program:
    ```
    javac main.java
    ```
4. Run the program:
    ```
    java main
    ```

---

## ⚠️ Possible Issues (Terminal Encoding)

This project uses **Unicode emoji symbols** to represent the slot machine icons.  
Depending on your operating system, terminal, or default encoding, the emojis may **not display correctly** or may cause unexpected behavior.

### Common Issue (Windows)

On some Windows systems, the default Command Prompt encoding does not fully support UTF-8, which can break emoji rendering.

### Solution

Changing the terminal encoding to UTF-8 usually fixes the problem.  
The following Stack Overflow post explains how to do this properly:

👉 https://stackoverflow.com/questions/57131654/using-utf-8-encoding-chcp-65001-in-command-prompt-windows-powershell-window

After applying the solution, restart your terminal and run the program again.

---

## 📝 Notes

This project focuses on simplicity and clarity rather than advanced Java features.

The main goal was to simulate a slot machine game while strengthening fundamental Java skills, improving user input handling, and creating a clean, enjoyable console-based experience.
