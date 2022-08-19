import java.util.Scanner

import com.manipal.exception.InvalidBookException
import com.manipal.model.Book
import com.manipal.store.BookStore

fun validateLength(bookId:String) {
   if(bookId.length!=4)
       throw InvalidBookException("Id must be of length 4")
}

fun validatePrice(price:Double){
    if(price<0)
        throw InvalidBookException("Price cannot be negative")
}

fun validateCategory(category: String){
    val listOfCategories = arrayListOf("Science","Fiction","Technology","Others")
    if(!listOfCategories.contains(category))
        throw InvalidBookException("Invalid Category ! ")
}

fun main() {

    val scanner = Scanner(System.`in`)
    println("Enter the number of books ")
    var count = readLine()!!.toInt()
    var bs  = BookStore()

    while(count>0){
        println("------------------------------------")
        println("Enter the book details : ")
        println("------------------------------------")
        println("Enter book id :")
        var bookId= scanner.nextLine()
        try {
            validateLength(bookId)

            println("Enter book title :")
            var title = readLine()!!.toString()

            println("Enter book author :")
            var author = readLine()!!.toString()

            println("Enter book category :")
            var category = readLine()!!.toString()
            validateCategory(category)

            println("Enter book price:")
            var price = readLine()!!.toDouble()
            validatePrice(price)


            var book = Book(bookId, title, author, category, price)
            bs.addBook(book)
            count--


        }catch (e:InvalidBookException){
            println(e.message)
        }
        catch (e:Exception){
            println(e.message)
        }

    }

    bs.displayAll()
    bs.updateBook()
    bs.displayAll()
    bs.searchByTitle("Search")
    bs.searchByAuthor("JK Rollings")
    println("Program Ended here")
    scanner.close()
}