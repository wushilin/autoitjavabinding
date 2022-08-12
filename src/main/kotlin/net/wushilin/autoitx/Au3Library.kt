package net.wushilin.autoitx

import com.sun.jna.Library
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.BaseTSD.SIZE_T
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.platform.win32.WinDef.DWORD
import com.sun.jna.platform.win32.WinDef.HWND
import com.sun.jna.platform.win32.WinNT.HANDLE
import com.sun.jna.ptr.IntByReference
import com.sun.jna.ptr.PointerByReference

interface Au3Library: Library {
    fun GetCursorID():DWORD
    fun OpenProcessByHandle(handle:HWND):HANDLE
    fun CloseProcessByHandle(handle:HANDLE)
    fun ReadMemoryInt(handle:HANDLE, address:Int):Int
    fun ReadMemoryFloat(handle:HANDLE, address:Int):Float
    fun ReadMemoryLong(handle:HANDLE, address:Int):Long
    fun WriteMemoryInt(handle:HANDLE, address:Int, value:Int):Boolean
    fun WriteMemoryFloat(handle:HANDLE, address:Int):Float
    fun WriteMemoryLong(handle:HANDLE, address:Int):Long
    fun DReadProcessMemory(process:HANDLE, address: Pointer, buffer: ByteArray, size:SIZE_T, readCount:IntByReference):Boolean
    fun DWriteProcessMemory(process:HANDLE, address:Pointer, buffer: ByteArray, size:SIZE_T, writtenCount:IntByReference):Boolean
}