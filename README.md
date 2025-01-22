# Base Converter (Base 2 to 36)

## Overview
The **Base Converter** is a simple Java application that allows users to convert numbers between different bases ranging from **Base 2 (binary)** to **Base 36**. It provides a step-by-step breakdown of the conversion process and supports multiple conversions in a single session.

**Note**: This application **does not support decimal numbers**. It only works with integer values in the specified base range (2 to 36).

## Features
- Convert numbers between any two bases from 2 to 36.
- Step-by-step explanation of the conversion process.
- User-friendly console interface with error handling.
- Option to perform multiple conversions.

## System Requirements

### Hardware Requirements:
- **OS:** Windows, macOS, or Linux
- **Processor:** Yes
- **Graphics**: Yes
- **Memory:** 2 GB RAM
- **Storage:** 500 MB available space


### Software Requirements:
- **Java Runtime Environment (JRE) 8 or later**
- **Java Development Kit (JDK) 8 or later** (for compiling, if needed)

## How to Run

### Option 1: Running the Application Using JAR File

1. **Download the JAR file:**
   Download the `BaseConverter_kmp.jar` from the repository 
2. **Ensure Java is Installed:**
   Make sure you have Java installed on your system. Open a terminal or command prompt and run the following command to verify your Java version:
   java -version
   Run the JAR file: Open a terminal or command prompt and navigate to the directory where the BaseConverter_kmp.jar file is located.

For example:

cd C:\path\to\your\jar\file

Then, run the JAR file using the following command:

    java -jar BaseConverter_kmp.jar

    Follow the Prompts: The program will prompt you to enter the number to convert, the base of the number, and the target base. After entering the values, it will display the step-by-step conversion.

Option 2: Running the Application from Source (for Developers)

    Clone the Repository: If you want to compile the code or make changes, clone the repository to your local machine:

git clone https://github.com/yourusername/BaseConverter_kmp.git
cd BaseConverter_kmp

Compile the Code: Ensure you have Java 8 or later installed. Use the following command to compile the Java files:

javac -d dist src/baseconverter_kmp/BaseConverter_kmp.java

Run the Program: After compiling, you can run the program with:

    java -jar dist/BaseConverter_kmp.jar

Disclaimer

This project is for educational purposes only. It is designed to demonstrate the process of base number conversion and is not intended for use in production environments. The application does not support decimal numbers (base 10) and is limited to integer-based conversions between bases 2 to 36.
License

This project is licensed under the MIT License
Contributions

Feel free to fork the repository, open issues, and submit pull requests to contribute to this project.
Acknowledgments

    Inspired by various numeral systems and base conversion algorithms.
    Special thanks to RapidTables for providing a base conversion tool for reference.

