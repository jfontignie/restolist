package com.restolist

import groovy.json.JsonSlurper

class GeoService {

    def geocode(Address address) {
        def addr = address.toParameters()

        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=${addr}")
        def json = url.text

        def slurper = new JsonSlurper()
        def result = slurper.parseText(json)

        String lng =result.results.geometry.location[0].lng
        String lat = result.results.geometry.location[0].lat

        def c = new Coordinate(latitude: lat, longitude: lng)

        return c;
    }
}
