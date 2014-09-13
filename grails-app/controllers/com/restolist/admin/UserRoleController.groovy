package com.restolist.admin

import com.restolist.UserRole
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class UserRoleController {

    static scaffold = UserRole
}
