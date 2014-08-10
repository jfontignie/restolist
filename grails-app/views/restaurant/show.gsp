<%@ page import="com.restolist.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-restaurant" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-restaurant" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list restaurant">

        <g:if test="${restaurantInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="restaurant.name.label"
                                                                        default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${restaurantInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${restaurantInstance?.address}">
            <li class="fieldcontain">
                <span id="address-label" class="property-label"><g:message code="restaurant.address.label"
                                                                           default="Address"/></span>

                <span class="property-value"
                      aria-labelledby="address-label">${restaurantInstance?.address?.encodeAsHTML()}</span>

            </li>
        </g:if>

        <g:if test="${restaurantInstance?.phoneNumber}">
            <li class="fieldcontain">
                <span id="phoneNumber-label" class="property-label"><g:message code="restaurant.phoneNumber.label"
                                                                               default="Phone Number"/></span>

                <span class="property-value" aria-labelledby="phoneNumber-label"><g:fieldValue
                        bean="${restaurantInstance}" field="phoneNumber"/></span>

            </li>
        </g:if>

    </ol>
    <g:each in="${entries.keySet()}" var="entry">

        <div class="content">
            <h1>${entry}</h1>
            <ol>
                <g:each in="${entries.get(entry)}" var="current">
                    <li>
                        <p class="entry">
                            <g:fieldValue bean="${current}"
                                          field="name"/>
                        </p>
                        <g:if test="${current.description}">
                            <p class="description">
                                <g:fieldValue bean="${current}"
                                              field="description"/>
                            </p>
                        </g:if>
                        <p class="price">
                            <g:fieldValue bean="${current}"
                                          field="price"/> CHF
                        </p>
                    </li>
                </g:each>
            </ol>
        </div>
    </g:each>
</div>
</body>
</html>
