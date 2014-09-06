<%@ page import="com.restolist.Restaurant" %>



<div class="fieldcontain ${hasErrors(bean: restaurantInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="restaurant.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${restaurantInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: restaurantInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="restaurant.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="address" name="address.id" from="${com.restolist.Address.list()}" optionKey="id" required="" value="${restaurantInstance?.address?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: restaurantInstance, field: 'phoneNumber', 'error')} required">
	<label for="phoneNumber">
		<g:message code="restaurant.phoneNumber.label" default="Phone Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="phoneNumber" required="" value="${restaurantInstance?.phoneNumber}"/>

</div>

