package com.restolist

class Country {
    String name

    String toString() {name}

    static constraints = {
        name(unique: true, blank: false)
    }
}
