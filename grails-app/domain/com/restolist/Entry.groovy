package com.restolist

class Entry {
    static searchable = true

    String name
    String description
    Restaurant restaurant
    EntryType type
    float price

    static belongsTo = [Restaurant]
    static hasMany = [ingredients: Ingredient]

    String toString() {
        String.format("%s\n%s\ntype:%s",name,description,type);
    }

    static constraints = {
        name(blank: false)
        description(blank: true,nullable: true)
        type(nullable: false)
        price(min: 0f)
    }
}

enum EntryType {
    MAIN, APPETIZER, DESERT
}
