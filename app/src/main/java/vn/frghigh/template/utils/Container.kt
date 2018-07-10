package vn.frghigh.template.utils

class Container<T : Any>(private val tClass: Class<T>) {
    val t: T = tClass.newInstance()

    companion object {
        inline operator fun <reified T : Any> invoke() = Container(T::class.java)
    }
}