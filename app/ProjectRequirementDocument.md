# Cars24 SDUI - PRD

## Objective

Build a reusable **Server Driven UI (SDUI)** system that renders the Cars24 Home Screen from a JSON file instead of hardcoded Jetpack Compose UI. The goal is to make future UI changes by updating JSON with minimal Android code changes.

---

## Tech Stack

- Kotlin 2.2.20
- Jetpack Compose
- MVVM
- Kotlinx Serialization

---

## Project Phases

### Phase 1 - Setup
- Create Android project
- Setup folder structure
- Add `home_screen.json`

### Phase 2 - JSON Schema
- Design JSON structure
- Define reusable UI components

### Phase 3 - Models
- Create Kotlin data models
- Parse JSON using Kotlinx Serialization

### Phase 4 - SDUI Engine
- JSON Parser
- Component Registry
- Screen Renderer
- Action Dispatcher

### Phase 5 - UI Components
- Header
- Search Bar
- Category Tabs
- Section
- Card
- Bottom Navigation

### Phase 6 - Integration
Connect the complete rendering flow.

```text
JSON
  ↓
Parser
  ↓
Renderer
  ↓
Component Registry
  ↓
Compose UI
```

### Phase 7 - Enhancements
- JSON Actions
- Unknown Component Fallback
- Version Support

### Phase 8 - Performance
- Build Static Screen
- Compare Static vs SDUI

### Phase 9 - Documentation
- README.md
- PERF.md
- COVERAGE.md
- AI_WORKFLOW.md

### Phase 10 - Demo
- Render screen from JSON
- Live JSON editing
- Unknown component demo

---

## Expected Outcome

- Dynamic UI rendered from JSON
- Reusable Compose components
- Clean and scalable SDUI architecture
- Future screens require mostly JSON changes instead of Android code