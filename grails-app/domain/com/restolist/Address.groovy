package com.restolist

class Address {
    static searchable = true
    String street1
    String street2
    String zipCode
    String city
    Country country
    //Coordinate coordinate

    String toString() {String.format("%s %s - %s - %s", street1, street2 ?: "", zipCode, country)}

    static constraints = {

        street1(blank: false)
        street2(blank: true,nullable: true)
        zipCode(blank: false)
        city(blank: false)
        country(nullable: false)
    }

    def toParameters() {
        "${street1}${street2==""? "" : "+${street2}"}+${zipCode}+${city}+${country}".replaceAll(" ","+")
    }
}
