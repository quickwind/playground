package com.gtunes

class Song {
    String title
    Date releasedAt
    String artist

    String toString() {
        return title
    }
    
    Album album
    
    static constraints = {
        title(blank: false)
        artist(blank: false)
    }
}
