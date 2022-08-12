import com.sun.jna.Native
import com.sun.jna.Pointer
import com.sun.jna.WString
import com.sun.jna.platform.win32.BaseTSD
import com.sun.jna.platform.win32.WTypes
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.ptr.IntByReference
import net.wushilin.autoitx.AU3Init
import net.wushilin.autoitx.Au3Library
import net.wushilin.autoitx.AutoitX
import net.wushilin.autoitx.DataUtil

fun main(args:Array<String>) {
    //System.setProperty("java.library.path", "./bin")
    val lib: AutoitX = Native.load("AutoItX3_x64", AutoitX::class.java)
    AU3Init.init(lib)
    val ct:Au3Library = Native.load("Au3Library", Au3Library::class.java)
    //testAU3(lib)
    testCT(ct, lib)
}

fun testCT(ct:Au3Library, lib:AutoitX) {
    lib.AU3_WinActivate(WString("Online"), WString(""))
    val hwnd = lib.AU3_WinGetHandle(WString(""), WString(""))
    val process = ct.OpenProcessByHandle(hwnd)
    println("Process $process handle $hwnd")
    val mana_address = 0x011B7180
    val msg_address = 0x11B6DF4
    while(true) {
        println(ct.GetCursorID())
        println("Money: ${ct.ReadMemoryInt(process, 0x11B7188)}")
        println("POS_X: ${ct.ReadMemoryFloat(process, 0x11B7200)}")
        ct.WriteMemoryInt(process, mana_address, 12)
        val real_address = ct.ReadMemoryInt(process, msg_address)
        println("Real address is ${real_address}" )
        val buffer = ByteArray(1024)
        val readCount = IntByReference(0);

        val readResult = ct.DReadProcessMemory(process, Pointer.createConstant(real_address), buffer, BaseTSD.SIZE_T(1024), readCount)
        println("Read result ${readResult}")
        println("Read count ${readCount.value}")
        println(String(buffer))
        Thread.sleep(1000)
    }
}
fun testAU3(lib:AutoitX) {
    AU3Init.init(lib)
    println(lib.AU3_WinActivate(WString("Online"), WString("")))
    println(lib.AU3_MouseGetCursor())
    println(lib.AU3_IsAdmin())
    lib.AU3_WinMinimizeAll()
    lib.AU3_ClipPut(WString("Hello, world" + System.currentTimeMillis()))
    var test = WString("")
    var buffer = DataUtil.allocateLPWSTR(50)

    lib.AU3_ClipGet(buffer, 50)
    println(buffer.value)
    println(test)
    for(i in 1..100){
        lib.AU3_MouseMove(i * 10, i * 10, 0)
        lib.AU3_Sleep(10)
    }
    println("About to sleep")
    lib.AU3_Sleep(50000)

}