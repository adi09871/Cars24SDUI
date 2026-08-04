# PERF

## Device

- Android Emulator
- API Level 36
- Debug Build

---

## Test Method

To compare the performance, the same Home Screen was implemented in two ways:

1. Static Jetpack Compose UI
2. SDUI (JSON → Parser → Renderer)

Both versions were run multiple times, and the average render time was observed using Android Studio.

---

## Results

| Implementation | Average Render Time |
|----------------|--------------------:|
| Static Compose | ~18 ms |
| SDUI | ~21 ms |

**Estimated Overhead:** ~17%

---

## Optimization

- Parsed the JSON only once.
- Reused Compose components.
- Used a Component Registry to keep rendering simple.

---

## Conclusion

The SDUI implementation adds a small rendering overhead because the UI is generated dynamically from JSON. However, the flexibility of updating the UI through JSON outweighs this small cost for most use cases.