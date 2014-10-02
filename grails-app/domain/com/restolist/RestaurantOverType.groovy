package com.restolist

class RestaurantOverType {

    static searchable = true

    String overType

    String toString() {overType}

    static constraints = {
        overType(blank: false, unique: true)
    }
}
