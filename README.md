# Cars24 SDUI

A proof-of-concept Server-Driven UI (SDUI) framework for Android using Jetpack Compose and Kotlin Serialization.

## 🚀 Overview

This project demonstrates how to build a dynamic, backend-driven interface where the layout, styling, and components are defined in a JSON file. This approach allows for instant UI updates without requiring an app store release.

## 📂 Documentation

- [PRD.md](ProjectRequirementDocument.md) - Project Requirements and Objectives
- [COVERAGE.md](COVERAGE.md) - Supported Components and Patterns
- [PERF.md](PERF.md) - Performance Comparison (Static vs SDUI)
- [AI_WORKFLOW.md](AI_WORKFLOW.md) - AI-Assisted Development Journey

## 🛠️ Tech Stack

- **Kotlin:** 2.2.10
- **UI:** Jetpack Compose
- **Architecture:** MVVM
- **Parsing:** Kotlinx Serialization

## 🏗️ Architecture

1. **Data Layer:** Fetches and parses `home_screen.json`.
2. **SDUI Engine:** Maps JSON types to Compose components via a `ComponentRegistry`.
3. **UI Layer:** Atomic, reusable components (Headers, Sections, Cards).

## 🏃 How it works

1. App reads `home_screen.json` from assets.
2. `Parser` deserializes the JSON into a `ScreenModel`.
3. `Renderer` iterates through components.
4. `ComponentRegistry` renders the corresponding Composable for each type.
