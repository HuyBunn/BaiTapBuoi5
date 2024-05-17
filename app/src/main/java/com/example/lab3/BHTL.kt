package com.example.lab3

import androidx.compose.ui.text.toUpperCase

fun main(){
    val soA = 5
    val soB = 10
    println("Cách 1: Tổng 2 số là:  ${tinhTong(soA,soB)}")
    println("Cách 2: Tổng 2 số là:  ${tinhTong2(soA,soB)}")
    println("Nhận đôi số 10: ${nhandoi(10)}")
    println("Chia đôi số 10: ${chiadoi(10f)}")
    println("Nhân đôi số 5: ${nhanDoi2}")
    val str = "Buổi 3 - Android Kotlin"
    println("Độ dài chuỗi ${str} : ${getStringLength(str)}")
    println("Độ dài chuỗi null : ${getStringLength(null)}")
    val tenSV = "phạm quang huy"
    val tenInHoa = with(tenSV){
        tenSV.toUpperCase()
    }
    println(tenInHoa)
    var xe1 = CarModel("Xe1",500f)
    println(xe1)
    xe1.apply {
        tenXe
    }

}
val tinhTong2 : (soA:Int,soB:Int) -> Int = { soA,soB ->
    val a =10
    val b = 5
    val c = a+b
    (soA +soB)
}
val chiadoi ={soA:Float -> soA/2}
val nhandoi :(Int)-> Int = {it*2}
//scope fun
val a = 5
val nhanDoi2 = a.let{
    it * 2
}



fun tinhTong(soA: Int,soB:Int):Int{
    return (soA+soB)
}
fun getStringLength(str:String?) :Int?{
    return str?.run {
        if (isEmpty())
            return 0
        length
    }
}