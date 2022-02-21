package com.example.tutorial.scopefunctions

fun main(args : Array<String>){

        /*
        Normal olarak bu şekilde yapabiliriz.
        Ama apply kullanarak daha az kod kalabalığını hedeflemiş oluyoruz.
        *******************************************************************
        val person = Person("Isil","subasi",27,"Artvin")
        person.name = "Işıl"
        person.surname=person.surname.uppercase()
        person.age.inc()
        person.city="İstanbul"
        println(person)
         */


    //.Apply - Extensions Functions
    //Aşağıdaki atamaları objeye uygulayın şeklinde anlaşılabilir.
        val person = Person("Isil","subasi",26,"antalya").apply {
            name = "Işıl"
            surname=surname.uppercase()
            age.inc()
            city="Samsun"
            println(this)
        }


    //.let - Extensions Functions
    val harf = charArrayOf('A', 'B', 'C', 'D', 'E')
    val harfFilter = harf.filter {
        it < 'C'
    }
    println(harfFilter)

    val harfFilterWithLet = harf.filter {
        it < 'C'
    }.let {
        it[0]
    }
    println(harfFilterWithLet)

    var x = "Anupam"
    x = x.let { outer ->
        outer.let { inner ->
            println("Inner is $inner and outer is $outer")
            "Kotlin Tutorials Inner let"
        }
        "Kotlin Tutorials Outer let"
    }
    println(x) //prints Kotlin Tutorials Outer let


    var example = "Isilay"
    example=example.let { yazi ->
        yazi.let {  inner ->
            println("Inner is $inner and outer is $yazi")
            "Kotlin"
        }
        "Kotlin dışarıdaki"
    }

    println(example)

    var nullcehck : String? = "isil"
    nullcehck?.let { isilsu ->
        println("Null değilse bu bloğa girecektir. " + isilsu)

    }


    //.also - Extensions Functions
    //objeyi değişime uğratmadan, loglama, debug gibi olaylar için kullanabiliriz.





}

data class Person(
    var name : String,
    var surname: String,
    var age : Int,
    var city : String

){



}