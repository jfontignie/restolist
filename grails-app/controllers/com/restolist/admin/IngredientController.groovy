package com.restolist.admin

import com.restolist.Ingredient
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class IngredientController {

    def scaffold = Ingredient
}
