## Darshilkumar Karkar (A00203357)
F2025 MAD204-01 Java Development for MA
Assignment 2
Objective

In this assignment, you will design and implement a multi-activity Android application that showcases advanced UI, navigation, lifecycle, persistence, and dynamic data handling concepts.

Finally, your app will:

Contain multiple screens with navigation between them.

Demonstrate activity lifecycle logging and state management.

Use RecyclerView with interactions (click, delete, undo, swipe).

Implement SharedPreferences for persistence.

Apply themes, styles, and custom UI design best practices.

Include: input forms, lists, and settings functionality.

Be version-controlled and documented using GitHub workflows.

Tasks
1. Project Setup

a. Project Name: Assignment2_YourName
b. Language: Kotlin
c. Minimum SDK: API 30 (Android 11)
d. Activities: At least 5 different activities/screens

2. Screens & Features
Screen 1 – Login (MainActivity)

UI: Email, Password, Login Button, Register Button

Validation: Email must contain “@”, Password >= 4 characters.

On Login → Save email in SharedPreferences, navigate to Dashboard.

On Register → Navigate to RegistrationActivity.

Screen 2 – Registration (RegistrationActivity)

UI: Full Name, Email, Age, Program, Register Button.

Validation: Age > 0, required fields cannot be empty.

On Register → Save details in SharedPreferences and go back to Login.

Screen 3 – Dashboard (DashboardActivity)

Displays “Welcome, [name/email]” from SharedPreferences.

Buttons to navigate to:

ProfileActivity

Countries ListActivity

SettingsActivity

Include Logout button → clears SharedPreferences and returns to Login.

Log all lifecycle methods (onCreate, onStart, etc.).

Screen 4 – Profile (ProfileActivity)

Displays stored user details from SharedPreferences.

Add “Edit Profile” button → allows updating stored values.

Persist updates in SharedPreferences.

Screen 5 – Countries List (ListActivity)

RecyclerView with at least 10 countries (bonus: add flag images).

Short click → Toast: “You selected: [country]”.

Long press → delete item with Snackbar UNDO.

Swipe → delete item (bonus).

Button to sort alphabetically.

If empty → show “No items available” message.

Screen 6 – Settings (SettingsActivity)

Switches & checkboxes for: Dark Mode, Notifications, etc.

Store user preferences in SharedPreferences.

On reopening, previous selections should persist.

3. UI Design & Styling

Use ConstraintLayout for all activity layouts.

Use styles.xml for consistent button and text styles.

Apply themes and colors from themes.xml.

Follow UI best practices:

Use dp and sp correctly.

Add hints for all EditTexts.

Add contentDescription for images.

Flat layouts (avoid deep nesting).

4. Lifecycle Logging

Implement lifecycle methods in DashboardActivity and ProfileActivity.

Use Log.d to print transitions (onCreate, onPause, etc.) to Logcat.

Document lifecycle behavior in your README.md.

5. Persistence with SharedPreferences

Store:

Login details (email, name, program)

Settings (dark mode, notifications)

On app restart:

If user is logged in → go directly to Dashboard

If not → show Login screen

6. Error Handling & Validation

Login form validation (empty fields, invalid email, password too short).

Registration form validation (age > 0, fields required).

Handle RecyclerView edge cases (empty list).

Wrap risky logic in try–catch when needed.

Documentation

When you submit your Java & Android Studio program, include proper documentation. Documentation is part of programming best practices and will count toward your grade.

File Header

At the top of every .java and .xml file include:

Course code and lab number

Your full name and Student ID

Date of Submission

A short description of what the program does

Class and Method Comments

Use /** ... */ for Java classes and methods

Use <!-- ... --> for Android XML files

Describe the class/method purpose

Mention parameters and return values

Inline Comments

Use // to explain tricky or important logic

Do not comment every line—only where needed

Submission
1. Create a Repository

a. Go to GitHub and create a new public repository.
b. Name it: MAD204-ASSIGNMENT2--YOURNAME
c. Add a README.md with:

Assignment title and your name / ID

A short description of the project

2. Code & Documentation

a. Add your .java files.
b. Include complete documentation:

File headers

Method/class Javadoc comments

Inline comments for tricky logic

3. Commit Requirements

At least 7 commits

Commit messages must be meaningful

4. Pull Request Requirements

At least 4 Pull Requests (PRs)

Each PR must have a clear title and description

Even if working alone:

Create a new branch

Push changes

Open a PR into main

Merge after review (self-review allowed)

5. What to Submit

Submit the GitHub Repository link

Ensure the repo is public

Marking Rubric (60 points)

Category	Marks

UI Design & Styling (all screens)	10

Login + Registration Screens	10

Dashboard Navigation & Logout	10

Profile Screen (view + edit preferences)	10

ListActivity (RecyclerView + Interactions)	10

Settings Screen (preferences)	10

Lifecycle logging	5

SharedPreferences (login persistence, settings)	5

Validation & Error Handling	5

Documentation (headers, Javadoc, Inline)	5

GitHub Workflows (commits, PRs, README)	5
