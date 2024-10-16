# Soul Parking's Junior Mobile Engineer Test

## UI
1. Main Page [x]
   - [x] AppBar for Title
   - [x] RecyclerView
   - [x] CardView
   - [x] TextView (Title)
   - [x] TextView (Desc)
   - [x] Date
2. Input Form []
   - [x] TextInput (Title)
   - [x] TextInput (Desc)
   - [x] DatePicker
3. Read Page []
   - [] AppBar for Title and Options
   - [] TextView (Title)
   - [] TextView (Desc)
   - [] Date

## Interfaces / Component Functionalities
1. Data Submission []
   After Successfully inputting data, the screen should navigate back to the main page, showing the new to-do item in the list.
2. Data Management []
   Use Room Database
3. Task Editing and Deletion []
   Implement swipe-to-delete functionality using ItemTouchHelper or provide a dialog for delete confirmation

## Bonus Points
1. Data Persistence []
   Use SharedPreferences or Room Database to store the data persistently.
2. Architecture []
   Implement the app using MVVM (Model-View-ViewModel) architecture with LiveData and ViewModel.
3. UI Enhancements []
   Implement simple animations, such as a fade-in effect when adding a new item to the list
4. State Management []
   Use ViewModel to manage UI-related data in a lifecycle-conscious way
5. Testing []
   - [] Create unit tests for key components, especially those handling input validation and data manipulation.
   - [] Implement UI tests using Espresso to verify the main flows, such as adding, editing, and deleting items.
   - [] Include at least one integration test that covers the entire flow (e.g. adding an item and checking if it appears on the main list).

# Development Environment
1. Gradle 8.9
2. Oracle OpenJDK 17.0.6
3. Medium Phone API 35