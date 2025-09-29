# Profile Notification Example

A simple Jetpack Compose app example that displays a **circular profile picture** with a **notification badge**. Users can toggle the visibility of the badge using a button.

---

## Features

- Circular profile image.
- Notification badge displayed at the bottom-right corner of the profile picture.
- Button to show/hide the badge dynamically.
- Centered layout using Jetpack Compose’s `Column` and `Box`.

---

## How it Works

1. **MainActivity**
   - Sets the content using `ProfileNotificationTheme` and a `Scaffold`.
   - Loads the `ProfileNotification` Composable.

2. **ProfileNotification Composable**
   - Uses a `Column` to center content both vertically and horizontally.
   - `Box` stacks the profile image and badge on top of each other.
   - `Image` displays the circular profile shape using `Modifier.clip(CircleShape)`.
   - Conditional `Box` shows the badge when `showBadge` is `true`.
   - `Button` toggles the badge visibility.

---

## Usage

1. Place your profile image in `app/src/main/res/drawable/` (e.g., `profileicon.png`).
2. Run the app in Android Studio.
3. Tap the "Show Badge"/"Hide Badge" button to toggle the notification badge.

---
