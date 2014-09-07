package com.restolist.admin

import com.restolist.Entry
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class EntryController {

    def scaffold = Entry
}
