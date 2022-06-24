package com.example.contact

data class DataList(
    val gender: String,
    val name: Name,
    val picture:Picture,
    val location: Location,
)

data class Name(
    val title:String,
    val first: String,
    val last:String
)
//
data class Location(
val country:String,
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)