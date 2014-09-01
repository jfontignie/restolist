package com.restolist

class Section {


    SectionType type
    Restaurant restaurant
    int priority

    static belongsTo = [Restaurant]
    static hasMany = [entries:Entry]
    static mapping = {sort priority: "asc"}

    static constraints = {
        type(nullable: false)
    }
}


