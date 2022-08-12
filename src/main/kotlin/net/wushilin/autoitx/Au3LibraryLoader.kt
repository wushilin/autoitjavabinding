package net.wushilin.autoitx

import com.sun.jna.Native

class Au3LibraryLoader {
    companion object {
        fun loadAu3LibraryX64():Au3Library {
            return Native.load("Au3Library_x64", Au3Library::class.java)
        }

        fun loadAu3LibraryW32():Au3Library {
            return Native.load("Au3Library", Au3Library::class.java)
        }
    }
}