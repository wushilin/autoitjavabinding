package net.wushilin.autoitx

import com.sun.jna.platform.win32.WTypes.LPWSTR

class DataUtil {
    companion object {
        fun allocateLPWSTR(length:Int):LPWSTR {
            val buffer = CharArray(length)
            return LPWSTR(buffer.toString())
        }
    }
}