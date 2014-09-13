package com.restolist

class Restaurant {


    static searchable = true
    String name
    Address address
    String phoneNumber
    String email
    String website
    //TimeTable timeTable

    //RestaurantType type

    Date dateCreated
    Date lastUpdated


    //static embedded = ['address']

    static hasMany = [sections:Section]

    String toString() {
        String.format("%s\n%s\n%s", name, address, phoneNumber)

    }

    def beforeValidate() {
        address.check()
    }

    static constraints = {
        name(blank: false)
        address(nullable: false)
        phoneNumber(blank: false)
        email(email: true, nullable: true)
        website(url: true, nullable: true)
    }
}

