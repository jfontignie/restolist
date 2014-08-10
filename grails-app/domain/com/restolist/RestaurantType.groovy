package com.restolist

class RestaurantType {
    String type

    String toString() {type}

    static constraints = {
        type(blank: false, unique: true)
    }
}
