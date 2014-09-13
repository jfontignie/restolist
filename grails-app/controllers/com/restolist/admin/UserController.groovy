package com.restolist.admin

import com.restolist.User
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class UserController {

    def scaffold = User
}
