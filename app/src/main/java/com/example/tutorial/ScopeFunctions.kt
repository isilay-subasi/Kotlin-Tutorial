package com.example.tutorial

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
    //letten farklı olarak aynı değeri döndürür.
    var m = 1
    m = m.also { it + 1 }.also { it + 1 }
    println(m) //prints 1
    data class Person2(var name: String, var tutorial : String)
    var person2 = Person2("Anupam", "Kotlin")

    var l = person2.let { it.tutorial = "Android" }
    var al = person2.also { it.tutorial = "Android" }

    println(l)//kotlin.Unit
    println(al)//Person2(name=Anupam, tutorial=Android)
    println(person2)//Person2(name=Anupam, tutorial=Android)


    //run function - 2 türlü olarakda kullanılabilir.
    var tutorial = "This is Kotlin Tutorial"
    println(tutorial) //This is Kotlin Tutorial
    tutorial = run {
        val tutorial = "This is run function"
        tutorial
    }
    println(tutorial) //This is run function

    //with functions
    //Bu object ile, aşağıdakileri gerçekleştir.
    val numbers = mutableListOf("one", "two", "three")
    with(numbers){
        println("'with' is called with argument $this")//'with' is called with argument [one, two, three]
        println("It contains $size elements")//It contains 3 elements
    }

    val firstAndLast = with(numbers){
        "The first element ${first()},"+"the last element ${last()}"
    }
    println(firstAndLast)//The first element one,the last element three



}

data class Person(
    var name : String,
    var surname: String,
    var age : Int,
    var city : String

){



}