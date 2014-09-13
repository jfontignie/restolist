package com.restolist.admin

import com.restolist.Role
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class RoleController {

    static scaffold = Role

}
