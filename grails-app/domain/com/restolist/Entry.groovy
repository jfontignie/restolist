package com.restolist

class Entry {
    static searchable = true

    String name
    String description

    Section section
    float price

    static belongsTo = [Section]
    static hasMany = [ingredients: Ingredient]

    String toString() {
        String.format("%s\n%s\ntype:%s",name,description,section);
    }

    static constraints = {
        name(blank: false)
        description(blank: true,nullable: true)
        price(min: 0f)
    }
}

