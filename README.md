# Java Hangman Game

A simple, console-based implementation of the classic Hangman game. The program selects a random word from a text file and challenges the player to guess it letter by letter before the "hangman" is fully drawn.

## 🚀 Features
* **File-Based Word Bank**: Dynamically loads words from an external `words.txt` file.
* **ASCII Art Visuals**: Progressive hangman drawings for each incorrect guess.
* **Case Insensitivity**: Automatically handles uppercase and lowercase inputs.
* **Resource Management**: Uses `try-with-resources` for safe file handling.

## 📂 Project Structure
* `src/Main.java`: Contains the game engine, file-reading logic, and ASCII art generator.
* `src/words.txt`: The dictionary file (one word per line).

## 🛠️ Requirements
* **Java Development Kit (JDK)**: Version 17 or higher is recommended.
* **IDE**: IntelliJ IDEA, Eclipse, or VS Code (or run via Terminal).

## 🎮 How to Play
1. Ensure `words.txt` is populated with words in the `src` folder.
2. Run the `Main.java` file.
3. Type a letter and press **Enter**.
4. You have **6 attempts** to guess the word correctly before the game ends.
