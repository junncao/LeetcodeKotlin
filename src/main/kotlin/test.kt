fun main(){
    val map = mutableMapOf<Char, Int>()
    map['c'] = 0
    map['c'] = map['c']!! + 1
    println(map['c'])
}