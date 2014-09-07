package com.restolist.admin

import com.restolist.RestaurantType
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class RestaurantTypeController {

    def scaffold = RestaurantType
}
