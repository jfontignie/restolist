package com.restolist

class SectionType {

    String type

    @Override
    String toString(){
        type
    }

    static constraints = {
        type(unique: true)
    }
}
