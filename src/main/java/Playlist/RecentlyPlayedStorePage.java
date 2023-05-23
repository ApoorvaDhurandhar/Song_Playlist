package Playlist;

public class RecentlyPlayedStorePage {
	 private recentlyPlayedStore store;

	    public RecentlyPlayedStorePage(int capacity) {
	        store = new recentlyPlayedStore(capacity);
	    }

	    public void addSong(String song, String user) {
	        store.addSong(song, user);
	    }

	    public String[] getRecentlyPlayedSongs(String user) {
	        return store.getRecentlyPlayedSongs(user);
	    }
}
