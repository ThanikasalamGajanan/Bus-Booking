## Summary

This update improves the Bus Reservation System by enhancing code quality, maintainability, and logging support.

### Changes Made

#### Bus Class

* Added JavaDoc documentation for the `Bus` class and its methods.
* Introduced `java.util.logging.Logger` for structured application logging.
* Marked bus-related fields (`route`, `type`, `normalPrice`, and `fullPrice`) as `final` to enforce immutability.
* Added input validation in `reduceSeats()` and `restoreSeats()` methods to prevent negative seat modifications.
* Improved the `display()` method by using logger-based output instead of direct console printing.

#### MainSystem Class

* Refactored the code into smaller, reusable methods to improve readability and maintainability.
* Added constants for menu options instead of using hard-coded values.
* Introduced centralized integer input validation through the `readInt()` method.
* Replaced most console output statements with logger messages for consistent application logging.
* Improved booking, cancellation, and admin login workflows with better validation and error handling.
* Added checks for duplicate bus registrations before creating new buses.
* Declared `MainSystem` as `final` and added a private constructor to prevent instantiation.

### Benefits

* Improved code readability and maintainability.
* Better error handling and input validation.
* Consistent logging throughout the application.
* Reduced code duplication.
* Enhanced reliability of booking and seat management operations.

### Related Issues

* Improves code quality and maintainability.
* Adds logging support for easier debugging and monitoring.
* Enhances validation to prevent invalid user input and seat management errors.
