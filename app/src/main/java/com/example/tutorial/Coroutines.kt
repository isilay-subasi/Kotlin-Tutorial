package com.example.tutorial

import kotlinx.coroutines.*

fun main(args : Array<String>){

        /*
        *dependency * implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
        * test()= launch coroutine oluşturur,ve yürütmeye devam eder.Bunun için ilk önce Complete yazılır.
        * test2()=Ama ben önce CoroutineScope çalışmasını istiyorsam, join koyarak bekletebilirim.
        *
        * */


   // test()
   // test2()
   // test3()
   // test4()
   // test5()
   // test6()
   // test7()
   // test8()
   // test9()
   // test10()
   //test11()
   // test12()
    coroutineScope()


}

fun test() = runBlocking {
    launch {
        println("Hello Coroutine")
    }

    println("Complete")
}  //Complete
   //Hello Coroutine

fun test2()= runBlocking {
    val job=launch {
        println("Hello Coroutine")
    }
    job.join()
    println("Complete")

} //Hello Coroutine
  //Complete


suspend fun printHello(count : Int){
    println("Hello $count")
    delay(1000)
}

fun test3()= runBlocking {
    launch {
        repeat(3){
            printHello(it)
        }
    }

    repeat(3){
        println("--- $it")
       delay(1000)
    }

    println("Completed")


}

fun test4()= runBlocking {
    val job=launch {
        val start= System.currentTimeMillis()
        for (i in 1..99999){
            println(i)
        }
        val spent=System.currentTimeMillis()-start
        println("Coroutine spent $spent")
    }

    delay(1)
    job.cancel()
    println("Complete")
}

fun test5()= runBlocking {
    val job=launch(start=CoroutineStart.LAZY) {
        println("Hello World")
    }

    println("Start Coroutine")
    job.start()
    println("Complete")
}

fun test6()= runBlocking {
    launch(this.coroutineContext + Dispatchers.Default) {
            println("child job:  ${Thread.currentThread().name}")
    }

    println("parent job : ${Thread.currentThread().name}")
}

fun test7()= runBlocking{
    launch(CoroutineName("child")) {
        println("HelloWorld")
    }
}

fun test8()= runBlocking {
    println("Current job is : ${coroutineContext[Job]}")
}

fun test9()= runBlocking {
    launch {
        println("parent job : ${Thread.currentThread().name}")
        launch {
            println("child job : ${Thread.currentThread().name}")
        }
    }
    println("runBlocking: ${Thread.currentThread().name}")
}

fun test10()= runBlocking {
    launch(Dispatchers.Default) {
        println("parent job : ${Thread.currentThread().name}")
        launch {
            println("child job : ${Thread.currentThread().name}")
        }
    }
    println("runBlocking: ${Thread.currentThread().name}")
}

fun test11()= runBlocking {
    val job = async {
            println("Hello Kotlers")
            "Complete"
    }
    val result = job.await()
    println(result)

}

fun test12()= runBlocking {
    val result= withContext(Dispatchers.Default){
        println("job: ${Thread.currentThread().name}")
        "Complete"
    }
    println("runBlocking : ${Thread.currentThread().name}")
    println(result)
}

fun coroutineScope() = runBlocking {
    coroutineScope {
        launch {
            println("job1: ${Thread.currentThread().name}")
        }
        launch {
            println("job2: ${Thread.currentThread().name}")
        }
    }

    println("runBlocking : ${Thread.currentThread().name}")
}

