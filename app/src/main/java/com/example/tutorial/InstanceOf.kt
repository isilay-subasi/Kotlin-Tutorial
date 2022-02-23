package com.example.tutorial

fun main(args : Array<String>){

    var shapeObject: Shape = Circle()
    var area: Float = 0.0f

    if (shapeObject is Circle){
       // print("It's a Circle")
        shapeObject.radius = 10.0f
        area = shapeObject.calculate()
    }
    else if (shapeObject is Square){
        //print("It's a Square")
        shapeObject.sideLength = 5.0f
        area = shapeObject.calculate()

    }
    else if (shapeObject is Rectangle) {
        //print("It's a Rectangle")
        shapeObject.length = 10.0f
        shapeObject.breadth = 5.0f
        area = shapeObject.calculate()
    }


    when(shapeObject){
        is Circle -> shapeObject.radius = 3.0f
        is Square -> shapeObject.sideLength = 4.0f
        is Rectangle -> {
            shapeObject.length = 5.0f
            shapeObject.breadth = 6.0f
        }
        else -> print("Undefined Type")

    }

    var count = 0
    while (count < 5 && shapeObject is Circle){
        shapeObject.radius = count.toFloat()
        area += shapeObject.calculate()
    }


    var otherShapeObject = shapeObject as Circle

}

interface Shape{
    fun calculate() : Float
}

class Circle : Shape{
    var radius : Float = 10.0f
    override fun calculate(): Float {
        return (22*radius*radius) / 7
    }

}

class Square : Shape{
    var sideLength : Float = 10.0f
    override fun calculate(): Float {
        return sideLength*sideLength
    }

}

class Rectangle : Shape{
    var length: Float = 10.0f
    var breadth: Float = 5.0f
    override fun calculate(): Float {
        return length * breadth
    }
}