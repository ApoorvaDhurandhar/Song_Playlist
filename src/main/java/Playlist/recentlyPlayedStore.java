package Playlist;

import java.util.HashMap;
import java.util.Map;

class recentlyPlayedStore {
    private int capacity;
    private Map<String, SongNode> songMap;
    private SongNode head;
    private SongNode tail;

    public recentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.songMap = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public void addSong(String song, String user) {
        if (songMap.containsKey(user)) {
            removeSong(user);
        }

        SongNode newNode = new SongNode(song, user);
        songMap.put(user, newNode);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        if (songMap.size() > capacity) {
            removeOldestSong();
        }
    }

    private void removeSong(String user) {
        SongNode node = songMap.get(user);

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        songMap.remove(user);
    }

    private void removeOldestSong() {
        String user = tail.user;
        removeSong(user);
    }

    public String[] getRecentlyPlayedSongs(String user) {
        if (songMap.containsKey(user)) {
            SongNode node = songMap.get(user);
            moveToFront(node);
            return getSongList();
        }

        return new String[0];
    }

    private void moveToFront(SongNode node) {
        if (node == head) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        node.next.prev = node.prev;
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    private String[] getSongList() {
        String[] songList = new String[songMap.size()];
        int index = 0;
        SongNode node = head;
        while (node != null) {
            songList[index++] = node.song;
            node = node.next;
        }
        return songList;
    }
}
