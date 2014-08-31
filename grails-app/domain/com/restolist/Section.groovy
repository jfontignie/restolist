package com.restolist

class Section {


    SectionType type
    Restaurant restaurant

    static belongsTo = [Restaurant]
    static hasMany = [entries:Entry]

    static constraints = {
        type(nullable: false)
    }
}


