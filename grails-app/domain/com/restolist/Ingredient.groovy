package com.restolist

class Ingredient {
    String name

    String toString() {name}

    static constraints = {
        name(unique: true, blank: false)
    }
}
