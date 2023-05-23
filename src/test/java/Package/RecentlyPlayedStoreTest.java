package Package;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Playlist.RecentlyPlayedStorePage;


public class RecentlyPlayedStoreTest {
    private RecentlyPlayedStorePage storePage;

    @BeforeMethod
    public void setup() {
        storePage = new RecentlyPlayedStorePage(3);
    }

    @Test
    public void testRecentlyPlayedSongs() {
        storePage.addSong("S1", "User1");
        storePage.addSong("S2", "User1");
        storePage.addSong("S3", "User1");
        storePage.addSong("S4", "User1");

        String[] songs = storePage.getRecentlyPlayedSongs("User1");

        //Assert.assertEquals(songs.length, 3);
        Assert.assertEquals(songs[0], "S4");
        Assert.assertEquals(songs[1], "S3");
        Assert.assertEquals(songs[2], "S2");
    }

    @Test
    public void testEmptyRecentlyPlayedSongs() {
        String[] songs = storePage.getRecentlyPlayedSongs("User1");

        Assert.assertEquals(songs.length, 0);
    }

    @Test
    public void testCapacityExceeded() {
        storePage.addSong("S1", "User1");
        storePage.addSong("S2", "User1");
        storePage.addSong("S3", "User1");
        storePage.addSong("S4", "User1");
        storePage.addSong("S5", "User1");

        String[] songs = storePage.getRecentlyPlayedSongs("User1");

        Assert.assertEquals(songs.length, 3);
        Assert.assertEquals(songs[0], "S5");
        Assert.assertEquals(songs[1], "S4");
        Assert.assertEquals(songs[2], "S3");
    }
}

