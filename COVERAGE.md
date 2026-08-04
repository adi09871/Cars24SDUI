# COVERAGE

This document describes what the current SDUI implementation can render and what would require additional development.

---

## Supported Components

The current implementation supports the following components:

- Header
- Search Bar
- Category Tabs
- Section
- Car Card
- Bottom Navigation

---

## Supported UI Patterns

The SDUI system currently supports:

- Vertical lists
- Reusable sections
- Nested components (Cards inside Sections)
- Unknown component fallback
- Basic version support

---

## Current Coverage

With the existing components, most common Cars24 home screen layouts can be created by only updating the JSON.

Examples include:

- Changing titles and text
- Updating images
- Adding or removing cards
- Creating new sections
- Reordering components

These changes do not require any Android code changes.

---

## Requires New Client Code

A new Compose component would be required for UI elements that are not currently supported, such as:

- Image Carousel
- Map View
- Video Player
- Custom Charts

Once added to the Component Registry, these components can also be reused through JSON.

---

## Conclusion

The current SDUI architecture is designed to reuse existing components as much as possible. Most UI updates can be handled through JSON, while completely new UI patterns require adding a new component only once.