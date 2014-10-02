package com.restolist

class RestaurantType {

    static searchable = true

    String type

    RestaurantOverType restaurantOverType

    String toString() {type}

    static constraints = {
        type(blank: false, unique: true)
    }
}
