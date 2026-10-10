# PROG209 — Java Swing Assignment

**Basic Interactive GUI · First Individual Assignment**

---

## Student Information

| Field            | Detail                              |
| :--------------- | :---------------------------------- |
| **Student**      | Mohamed E Amara                     |
| **Module**       | PROG209 — Event Driven Programming  |
| **Assignment**   | Basic Interactive GUI               |
| **Language**     | Java (JDK 1.8 / Java SE 8)         |
| **GUI Framework**| Java Swing                          |
| **Design Tool**  | Figma                               |
| **IDE**          | Visual Studio Code                  |

---

## Project Overview

This repository contains a Java Swing desktop application developed for the PROG209 Event Driven Programming individual assignment. The application constructs a fully functional graphical user interface that displays a personalised welcome message and exposes interactive controls allowing the user to customise the label text and the panel background colour at run time.

The project demonstrates core object-oriented and event-driven programming concepts including inheritance, constructor-based initialisation, and anonymous `ActionListener` implementations.

---

## Features

| Feature                    | Description                                                                                  |
| :------------------------- | :------------------------------------------------------------------------------------------- |
| **Welcome Message**        | A `JLabel` displays "Welcome to Java Swing First Individual Assignment by Mohamed E Amara"   |
| **Update Label Text**      | Type new text into the input field and click **Update Label Text** to change the label       |
| **Change Background Color**| Opens a native `JColorChooser` dialog to set the `JPanel` background colour                  |
| **Reset Defaults**         | Restores the original welcome text and default background colour in one click                |
| **Application Icon**       | A custom icon (`assets/app-icon.png`) is loaded via `ImageIcon` with an automatic fallback   |
| **Header Bar**             | Displays the module name and student identity at the top of the window                       |
| **OOP Inheritance**        | `CustomPanel extends JPanel` demonstrates Java inheritance within the application             |

---

## Technologies

- **Java SE 8** (JDK 1.8) — core language and runtime
- **Java Swing** — GUI framework (`JFrame`, `JPanel`, `JLabel`, `JButton`, `JTextField`, `JColorChooser`, `ImageIcon`)
- **Figma** — wireframe and prototype design
- **Visual Studio Code** — development environment

---

## Project Structure

```
SwingAssignment/
├── src/
│   └── SwingAssignment.java        # Main application source code
├── assets/
│   └── app-icon.png                # Application window icon
├── Wireframes/
│   ├── low-fidelity-wireframe.png  # Figma low-fidelity design
│   └── high-fidelity-wireframe.png # Figma high-fidelity design
├── Screenshots/
│   └── running-application.png     # Screenshot of the running application
├── Documentation/
│   └── PROG209_Java_Swing_Assignment_Mohamed_E_Amara.docx
├── README.md
└── .gitignore
```

---

## Requirements

- **Java SE 8 (JDK 1.8)** or later is required to compile and run the application.
- No third-party libraries are used. Only the standard Java SE class library is required.

To check your Java version:
```bash
java -version
```

---

## Compilation and Execution

Run all commands from the **project root directory** (`SwingAssignment/`).

### Compile

```bash
javac -d bin src/SwingAssignment.java
```

### Run

```bash
java -cp bin SwingAssignment
```

> **Important:** The application must be launched from the project root directory so that the relative path `assets/app-icon.png` resolves correctly. If the icon file is not found the application will use an automatically generated fallback icon and continue without error.

### Windows Batch Launcher

A convenience batch file is provided. Double-click `run.bat` or run from PowerShell:

```powershell
.\run.bat
```

---

## Wireframes

The interface was designed in Figma using a two-stage design process.

| Stage           | File                                                   |
| :-------------- | :----------------------------------------------------- |
| Low-Fidelity    | [`Wireframes/low-fidelity-wireframe.png`](Wireframes/low-fidelity-wireframe.png)   |
| High-Fidelity   | [`Wireframes/high-fidelity-wireframe.png`](Wireframes/high-fidelity-wireframe.png) |

---

## Screenshots

| Description          | File                                                        |
| :------------------- | :---------------------------------------------------------- |
| Running application  | [`Screenshots/running-application.png`](Screenshots/running-application.png) |

---

## Documentation

The full assignment report is located at:

[`Documentation/PROG209_Java_Swing_Assignment_Mohamed_E_Amara.docx`](Documentation/PROG209_Java_Swing_Assignment_Mohamed_E_Amara.docx)

---

## Academic Purpose

This project was developed solely for the PROG209 Event Driven Programming individual assignment. It is submitted for academic assessment purposes only.
