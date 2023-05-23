package Playlist;

public class SongNode {
	 String song;
	    String user;
	    SongNode prev;
	    SongNode next;

	    public SongNode(String song, String user) {
	        this.song = song;
	        this.user = user;
	        this.prev = null;
	        this.next = null;
	    }

}
