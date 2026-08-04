# Cars24 SDUI

A Server-Driven UI (SDUI) implementation built with **Kotlin** and **Jetpack Compose**. The application renders the Cars24 Home Screen from a JSON configuration instead of hardcoded UI, making it easier to update the interface without releasing a new app version.

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
│   │   │   │
│   │   │   ├── sdui/
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
- Reusable Jetpack Compose components
- MVVM architecture
- Component Registry for dynamic rendering
- Kotlinx Serialization for JSON parsing
- Graceful fallback for unknown components
- JSON version support

---

## SDUI Design

### Component Registry

Each UI component in the JSON contains a `type`. The registry maps the component type to its corresponding Jetpack Compose implementation.

Example:

```json
{
  "type": "header"
}
```

This keeps the renderer generic and makes it easy to add new components.

---

### Unknown Component Fallback

If the backend sends a component that the current app version doesn't support, the application skips it safely instead of crashing.

Example:

```json
{
  "type": "new_component"
}
```

Fallback:

```text
Unsupported Component: new_component
```

This allows newer server payloads to remain compatible with older app versions.

---

### Versioning

Each screen contains a version number.

```json
{
  "screen": {
    "version": "1.0"
  }
}
```

The client validates the version before rendering. Unsupported components are ignored gracefully, allowing older app versions to work with newer server payloads.

---


## Future Improvements

- Fetch JSON from a remote API
- Theme configuration from JSON
- Remote feature flags
- Component caching
- A/B testing support

---


