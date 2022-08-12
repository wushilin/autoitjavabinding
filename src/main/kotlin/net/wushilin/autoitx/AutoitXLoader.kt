package net.wushilin.autoitx

import com.sun.jna.Native

class AutoitXLoader {
    companion object {
        fun loadAutoit3X64():AutoitX {
            val lib: AutoitX = Native.load("AutoItX3_x64", AutoitX::class.java)
            return lib
        }

        fun loadAutoit3W32():AutoitX {
            val lib: AutoitX = Native.load("AutoItX3", AutoitX::class.java)
            return lib
        }
    }
}