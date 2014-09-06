package com.restolist.admin

import com.restolist.Restaurant
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class RestaurantController {

    def scaffold = Restaurant
}
