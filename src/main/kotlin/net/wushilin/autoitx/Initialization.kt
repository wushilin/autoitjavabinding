package net.wushilin.autoitx

import com.sun.jna.WString

class AU3Init {
    companion object {
        fun init(aux:AutoitX) {
            aux.AU3_Init()
            aux.AU3_AutoItSetOption(WString("MouseCoordMode"), 0)
            aux.AU3_AutoItSetOption(WString("MouseCoordMode"), 0)
            aux.AU3_AutoItSetOption(WString("PixelCoordMode"), 0)
            aux.AU3_AutoItSetOption(WString("CaretCoordMode"), 0)
            aux.AU3_AutoItSetOption(WString("WinTitleMatchMode"), 2)
            aux.AU3_AutoItSetOption(WString("MouseClickDownDelay"), 160);
            aux.AU3_AutoItSetOption(WString("MouseClickDelay"), 125);
            aux.AU3_AutoItSetOption(WString("SendKeyDownDelay"),125)
        }
    }
}