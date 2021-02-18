package com.dean.homemarketplace.model

import com.google.gson.annotations.SerializedName

data class ResponseItem(

	@field:SerializedName("address")
	var address: String? = null,

	@field:SerializedName("furnished")
	var furnished: String? = null,

	@field:SerializedName("price")
	var price: String? = null,

	@field:SerializedName("surface_area")
	var surfaceArea: String? = null,

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("certificate")
	var certificate: String? = null,

	@field:SerializedName("developer")
	val developer: String? = null,

	@field:SerializedName("number_of_floors")
	var numberOfFloors: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("property_facilities")
	var propertyFacilities: String? = null,

	@field:SerializedName("type")
	var type: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)
