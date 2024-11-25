package levi.lin.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform