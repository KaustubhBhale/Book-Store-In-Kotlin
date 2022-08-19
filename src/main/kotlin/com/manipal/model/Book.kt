package com.manipal.model

data class Book(val bookId:String, var title:String, var author:String, var category:String, var price:Double) {

    override fun toString(): String {
        return "$bookId,$title,$author,$category,$price"
    }
}