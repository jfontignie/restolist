package com.restolist.admin

import com.restolist.Address
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class AddressController {

    def scaffold = Address

}
