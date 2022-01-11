package com.gowtham.githubrepos.navigation

sealed class Screens(val route: String) {
    object HomeScreen : Screens("Home")

    // add other screens

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }

    fun withArgs(args: Map<String, String>): String {
        return buildString {
            append(route)
            append("?")
            val iterator = args.iterator()
            while (iterator.hasNext()) {
                val map = iterator.next()
                append(map.key + "=" + map.value)
                if (iterator.hasNext())
                    append("&")
            }
        }
    }
}
