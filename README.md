# Song_Playlist
 In-memory store for recently played songs
 
 This is a Java implementation of an in-memory store for recently played songs. 
 The store maintains a list of recently played songs per user and has a fixed initial capacity.
 When the store becomes full, it automatically removes the least recently played songs to accommodate new entries.

## Implementation Details

The implementation follows the Page Object Model (POM) design pattern, separating the interactions with the store into a dedicated page object class.
This promotes code modularity and test maintainability.

The code consists of the following main components:

1. `SongNode`: Represents a node in the doubly linked list that stores the recently played songs and their associated users.

2. `recentlyPlayedStore`: Implements the in-memory store functionality, including adding songs, removing the oldest songs, 
3. and retrieving recently played songs for a given user.

3. `RecentlyPlayedStorePage`: Acts as a page object for interacting with the `RecentlyPlayedStore` class.
4.  It encapsulates the operations and provides a higher-level interface.

4. `RecentlyPlayedStoreTest`: Contains TestNG test methods to validate the functionality of the `RecentlyPlayedStorePage` class.

## Getting Started

To use the recently played songs in-memory store in your Java project, you can follow these steps:

1. Clone the repository or download the source code files.

2. Add the relevant classes (`SongNode`, `recentlyPlayedStore`, `RecentlyPlayedStorePage`) to your project.

3. Use the `RecentlyPlayedStorePage` class to interact with the recently played songs store. Instantiate an object of the `RecentlyPlayedStorePage` 
 class with the desired capacity, and then use the provided methods (`addSong`, `getRecentlyPlayedSongs`) to add songs and retrieve recently played songs for a user.

4. Customize the provided TestNG test methods in the `RecentlyPlayedStoreTest` class or write your own tests to validate the functionality
 of the recently played songs store in your specific use cases.

## Testing

The provided TestNG test methods in the `RecentlyPlayedStoreTest` class can be executed to test the functionality of the recently played songs store. 
These tests cover scenarios such as adding songs, retrieving recently played songs, and handling capacity constraints.

To run the tests, you can use any TestNG-compatible test runner or execute the tests using build tools like Maven.

 
