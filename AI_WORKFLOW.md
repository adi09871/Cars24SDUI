# AI-Assisted Development Workflow

This document explains how AI tools were used during the development of the Cars24 SDUI project. AI was mainly used to brainstorm ideas, generate initial code, and speed up development, while the final implementation and project structure were decided manually.

---

## Tools Used

- Android Studio Gemini
- ChatGPT
- Jetpack Compose
- Kotlin Serialization

---

# Prompt → Outcome

## 1. Project Structure

**Prompt**

> "Suggest a folder structure for an Android SDUI project."

**AI Outcome**

AI suggested a basic project structure with data, UI, and rendering classes.

**What I Changed**

I reorganized the project into separate packages like `data`, `sdui`, and `ui` to keep parsing, rendering, and UI components independent and easier to maintain.

---

## 2. JSON Schema

**Prompt**

> "Create a JSON structure for a Cars24 home screen."

**AI Outcome**

AI generated a basic JSON with reusable UI components like Header, Search Bar, Sections, Cards, and Bottom Navigation.

**What I Changed**

I simplified the schema by removing unnecessary fields and kept only the data required for rendering the UI.

---

## 3. Dynamic Rendering

**Prompt**

> "How can I render different Compose components from JSON?"

**AI Outcome**

AI suggested using a Component Registry that maps each component type to its corresponding Compose UI.

**What I Changed**

I adapted the idea to fit my project structure and kept the renderer generic so that new components can be added with minimal code changes.

---

# AI Limitation

One challenge I faced was that if I started generating code without a proper project plan or documentation, the AI often produced inconsistent code or repeated different approaches in multiple iterations.

To solve this, I first created a simple **Project Requirements Document (PRD)**. Once the project structure, phases, and architecture were clearly defined, the AI responses became much more consistent and aligned with the project.

---

# Verification

The generated code was verified using simple checks during development:

- Built the project after each major change.
- Verified JSON parsing by loading `home_screen.json`.
- Checked the UI in the Android Emulator.
- Fixed compile-time and runtime errors before moving to the next phase.

---

