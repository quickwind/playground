package com.gtunes

class Album {
    String title
    
    String toString() {
        return title
    }
    static hasMany = [songs:Song]
}
