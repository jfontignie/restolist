package com.restolist

class Restaurant {

    static searchable = true
    String name
    Address address
    String phoneNumber

    Date dateCreated
    Date lastUpdated

    static embedded = ['address']

    static hasMany = [entries: Entry]

    String toString() {
        String.format("%s\n%s\n%s", name, address, phoneNumber)

    }

    static constraints = {
        name(blank: false)
        address(nullable: false)
        phoneNumber(blank: false)
    }
}

