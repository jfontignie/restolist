package com.restolist

import grails.transaction.Transactional
import org.apache.commons.logging.LogFactory
import org.compass.core.engine.SearchEngineQueryParseException
import org.springframework.security.access.prepost.PreAuthorize

import static org.springframework.http.HttpStatus.NOT_FOUND

/**
 * RestaurantController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
@PreAuthorize('permitAll()')
@Transactional(readOnly = true)
class ListController {
    static String WILDCARD = "*"
    def searchableService
    private static final log = LogFactory.getLog(this)

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {

        respond Restaurant.list(params), model: [restaurantInstanceCount: Restaurant.count()]
    }

    def search = {
        if (!params.q?.trim()) {
            return [:]
        }
        try {
            String searchTerm = WILDCARD + params.q + WILDCARD
            def result = Restaurant.search(searchTerm, params).results

            flash.message = "${result.size()} restaurants have been found"
            render(view: "index", model: [restaurantInstanceList: result, restaurantInstanceCount: result.count])
        } catch (SearchEngineQueryParseException ignored) {
            return [parseException: true]
        }
    }


    def show(Restaurant restaurantInstance) {
        def result = [:]
        respond restaurantInstance
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'restaurantInstance.label', default: 'Restaurant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
