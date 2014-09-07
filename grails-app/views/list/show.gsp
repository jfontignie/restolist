<%@ page import="com.restolist.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
    <g:render template="analytics"/>
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

        <g:render template="map"/>

    </ol>
    <g:each in="${restaurantInstance?.sections.sort { it.priority }}" var="section">

        <div class="content">
            <h1>${section.type}</h1>

            <table>
                <g:each in="${section.entries.sort { it.priority }}" var="current">
                    <tr>
                        <td>
                            <p class="entry">
                                <g:fieldValue bean="${current}"
                                              field="name"/>
                            </p>


                            <g:if test="${current.description}">
                                <div>
                                    <p class="description">
                                        <g:fieldValue bean="${current}"
                                                      field="description"/>
                                    </p>
                                </div>
                            </g:if>
                        </td>
                        <td width="20%">

                            <p class="price">
                                <g:fieldValue bean="${current}"
                                              field="price"/> CHF
                            </p>
                        </td>
                    </tr>
                </g:each>
            </table>

        </div>
    </g:each>
</div>
</body>
</html>
