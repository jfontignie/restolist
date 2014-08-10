package com.restolist

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CrudRestaurantController {

    def scaffold = Restaurant
}
