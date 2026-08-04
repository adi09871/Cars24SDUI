# Cars24 SDUI

A Server-Driven UI (SDUI) implementation built with **Kotlin** and **Jetpack Compose** that renders the Cars24 Home Screen dynamically from a JSON configuration instead of hardcoded UI.

## Overview

Traditional Android applications require a new app release for every UI change. This project demonstrates how an SDUI architecture allows the backend to control the UI through JSON, enabling faster updates, feature rollouts, and A/B testing without changing the application code.

## Features

- Server-Driven UI architecture
- Dynamic UI rendering from JSON
- Reusable Jetpack Compose components
- Component Registry pattern
- JSON parsing with Kotlinx Serialization
- MVVM architecture
- Unknown component fallback
- Extensible component system

## Tech Stack

- Kotlin 2.2.20
- Jetpack Compose
- MVVM
- Kotlinx Serialization

## Project Structure

```text
app/
├── src/
│   ├── main/
│   │   ├── assets/
│   │   │   └── home_screen.json
│   │   ├── java/com/aditya/sdui/
│   │   │   ├── data/
│   │   │   │   ├── model/
│   │   │   │   ├── parser/
│   │   │   │   └── repository/
│   │   │   │
│   │   │   ├── sdui/
│   │   │   │   ├── actions/
│   │   │   │   ├── registry/
│   │   │   │   └── renderer/
│   │   │   │
│   │   │   ├── ui/
│   │   │   │   ├── components/
│   │   │   │   ├── screens/
│   │   │   │   └── theme/
│   │   │   │
│   │   │   └── MainActivity.kt
│   │   │
│   │   └── res/
```

## SDUI Workflow

```text
home_screen.json
        │
        ▼
   JSON Parser
        │
        ▼
 Kotlin Models
        │
        ▼
 Screen Renderer
        │
        ▼
Component Registry
        │
        ▼
 Jetpack Compose UI
```


## Goals

- Render the complete Home Screen from JSON.
- Create reusable Compose components.
- Keep the architecture scalable and maintainable.
- Minimize Android code changes for future UI updates.

## License

This project is created for learning and demonstration purposes.
