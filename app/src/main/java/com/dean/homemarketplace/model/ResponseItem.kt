package com.dean.homemarketplace.model

import com.google.gson.annotations.SerializedName

data class ResponseItem(

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("furnished")
	val furnished: String? = null,

	@field:SerializedName("price")
	val price: String? = null,

	@field:SerializedName("surface_area")
	val surfaceArea: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("certificate")
	val certificate: String? = null,

	@field:SerializedName("developer")
	val developer: String? = null,

	@field:SerializedName("number_of_floors")
	val numberOfFloors: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("property_facilities")
	val propertyFacilities: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)
