package com.restolist

import groovy.json.JsonSlurper

class GeoService {


    public static final String OK_STRING = "OK"

    def geocode(Address address) {
        log.debug("Getting coordinate of: " + address)
        def addr = address.toParameters()

        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=${addr}")
        def json = url.text

        def slurper = new JsonSlurper()
        def result = slurper.parseText(json)

        String status = result.status;
        if (status.equals(OK_STRING)) {

            String lng = result.results.geometry.location[0].lng
            String lat = result.results.geometry.location[0].lat

            def c = new Coordinate(latitude: lat, longitude: lng)

            log.debug("found: " + address)
            return c;
        } else {
            log.error("Impossible to get the localization: " + status)
            return null;
        }



    }
}
