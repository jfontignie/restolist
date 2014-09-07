package com.restolist.admin

import com.restolist.Country
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CountryController {

    def scaffold = Country
}
