# Cars24 SDUI

A Server-Driven UI (SDUI) implementation built with Kotlin and Jetpack Compose. The application renders the Cars24 Home Screen from a JSON configuration, allowing UI updates without changing the app code.

---

## Tech Stack

- Kotlin 2.2.20
- Jetpack Compose
- MVVM
- Kotlinx Serialization

---

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
│   │   │   ├── sdui/
│   │   │   │   ├── registry/
│   │   │   │   └── renderer/
│   │   │   ├── ui/
│   │   │   │   ├── components/
│   │   │   │   ├── screens/
│   │   │   │   └── theme/
│   │   │   └── MainActivity.kt
│   │   └── res/
```

---

## Architecture

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

---

## Features

- Dynamic UI rendering from JSON
- Reusable Compose components
- Component Registry for mapping JSON to UI
- MVVM architecture
- Kotlinx Serialization for parsing
- Graceful fallback for unknown components
- Version-aware JSON support

---

## SDUI Concepts

### Component Registry

Each JSON component contains a `type`. The registry maps that type to the corresponding Compose component.

Example:

```json
{
  "type": "header"
}
```

This keeps the renderer generic and makes adding new components simple.

---

### Actions

User interactions are described in JSON instead of hardcoded logic.

Examples include:

- Navigation
- Button clicks
- Bottom sheet
- State updates

The renderer dispatches these actions to the appropriate handler.

---

### Unknown Component Fallback

If the server sends a component that isn't supported by the current app version, the renderer skips it and displays a simple fallback instead of crashing.

Example:

```json
{
  "type": "new_component"
}
```

Output:

```
Unsupported Component: new_component
```

---

### Versioning

Each screen payload includes a version.

```json
{
  "screen": {
    "version": "1.0"
  }
}
```

Older app versions continue rendering supported components while safely ignoring unsupported ones.

---



## Future Improvements

- Remote API instead of local JSON
- A/B testing support
- Theme configuration from JSON
- Remote feature flags
- Component caching

---

