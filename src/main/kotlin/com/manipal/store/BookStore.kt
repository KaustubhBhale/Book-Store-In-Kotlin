package com.manipal.store

import java.util.Scanner
import com.manipal.store.BookStore
import com.manipal.model.Book
import com.manipal.exception.InvalidBookException

class BookStore {

    private val scanner = Scanner(System.`in`)
    var listOfBooks : ArrayList<Book> = ArrayList()

    fun addBook(b:Book){
        listOfBooks.add(b)
    }

    fun updateBook(){
        println("Enter the bookId to be updated : ")
        var bookId = scanner.nextLine()
        for(b in listOfBooks){
            if(b.bookId==bookId){
                //update fields
                var choice : Int =0
                do{
                    println("1. Update Title")
                    println("2. Update Author")
                    println("3. Update Category")
                    println("4. Update Price")
                    println("5. Exit")
                    println("Input your choice to update field : ")
                    choice = scanner.nextInt()

                    when(choice){
                        1->{
                            println("Enter new Title : ")
                            var title = readLine()
                            b.title=title.toString()
                            println("Title updated Successfully !\n")
                            break
                        }
                        2->{
                            println("Input the author :")
                            var author = readLine()
                            b.author=author.toString()
                            println("Author updated Successfully !\n")
                            break
                        }
                        3->{
                            println("Input new Category : ")
                            var category= readLine()
                            b.category=category.toString()
                            println("Category updated Successfully !\n")
                            break
                        }
                        4->{
                            println("Input new Price : ")
                            var price= readLine()!!.toDouble()
                            b.price= price
                            println("Category updated Successfully !\n")
                            break
                        }
                        5->{
                            return
                        }
                        else->{
                            println("Invalid Choice ! Input a proper choice")
                        }
                    }
                }while(choice!=5)

            }
        }

    }

    fun searchByTitle(title:String){
        var t = title
        var flag=false
        for(b in listOfBooks){
            if(b.title==t){
                flag=true
                println("Book id of the given title is : ${b.bookId}")
            }
            continue
        }
        if(!flag){
            println("------------------------------------")
            println("No book found with the given author")
            println("------------------------------------")
        }
    }

    fun searchByAuthor(author:String){
        var flag = false
        for(b in listOfBooks){
            if(b.author==author){
                flag=true
                println("\nBook details with author $author are-")
                println("Id : ${b.bookId}")
                println("Title : ${b.title}")
                println("Category: ${b.category}")
                println("Price : ${b.price}")
            }
        }
        if(!flag){
            println("No book found with given author")
        }
    }

    fun deleteBook(bookId : String){
        for(b in listOfBooks){

        }
    }

    fun displayAll(){
        if(listOfBooks.isEmpty()){

            println("Nothing to display")
        }

        else{
            for(book in listOfBooks){
                println("------------------------------------")
                println("ID         : ${book.bookId}")
                println("Title      : ${book.title}")
                println("Author     : ${book.author}")
                println("Category   : ${book.category}")
                println("Price      : ${book.price}")
                println("------------------------------------")
            }
        }
    }


}