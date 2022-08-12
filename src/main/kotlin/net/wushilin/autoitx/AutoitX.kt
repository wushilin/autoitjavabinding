package net.wushilin.autoitx

import com.sun.jna.*
import com.sun.jna.platform.win32.WTypes
import com.sun.jna.platform.win32.WTypes.LPWSTR
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.platform.win32.WinDef.HINSTANCE
import com.sun.jna.platform.win32.WinDef.HWND
import com.sun.jna.platform.win32.WinDef.RECT
import com.sun.jna.platform.win32.WinDef.POINT


interface AutoitX : Library {
    companion object {
        val AU3_INTDEFAULT = -2147483647
        val SW_HIDE = 0
        val SW_SHOW = 5
        val SW_SHOWNORMAL = 1
        val SW_NORMAL = 1
        val SW_SHOWMINIMIZED = 2
        val SW_SHOWMAXIMIZED = 3
        val SW_MAXIMIZED = 3
        val SW_SHOWNOACTIVATE = 4
        val SW_MINIMIZE = 6
        val SW_SHOWMINNOACTIVE = 7
        val SW_SHOWNA = 8
        val SW_RESTORE = 9
        val SW_SHOWDEFAULT = 10
        val SW_FORCEMINIMIZE = 11
    }
    fun AU3_error():Int
    fun AU3_Init()
    fun AU3_AutoItSetOption(szOption:WString, nValue:Int):Int
    fun AU3_ClipGet(szClip: LPWSTR, nBufSize:Int)
    fun AU3_ClipPut(szClip:WString)
    fun AU3_ControlClick(szTitle:WString, szText:WTypes.LPWSTR, szControl:WTypes.LPWSTR,
                         szButton:LPWSTR, nNumClicks:Int, nX:Int= AU3_INTDEFAULT, nY:Int= AU3_INTDEFAULT):Int
    fun AU3_ControlClickByHandle(hWnd:HWND, hCtrl:HWND, szButton:WString, nNumClicks:Int, nX:Int = AU3_INTDEFAULT, nY:Int = AU3_INTDEFAULT):Int
    fun AU3_ControlCommand(szTitle:WString, szText:WString, szControl:WString, szCommand:WString, szExtra:WString, szResult:WString, nBufSize:Int);
    fun AU3_ControlCommandByHandle(hWnd:HWND, hCtrl:HWND, szCommand:WString, szExtra:WString, szResult:LPWSTR, nBufSize:Int);
    fun AU3_ControlListView(szTitle:WString, szText:WString, szControl:WString, szCommand:WString, szExtra1:WString, szExtra2:WString, szResult:LPWSTR, nBufSize:Int);
    fun AU3_ControlListViewByHandle(hWnd:HWND , hCtrl:HWND , szCommand:WString, szExtra1:WString, szExtra2:WString, szResult:LPWSTR, nBufSize:Int);
    fun AU3_ControlDisable( szTitle:WString,  szText:WString,  szControl:WString):Int
    fun AU3_ControlDisableByHandle(hWnd:HWND , hCtrl:HWND ):Int
    fun AU3_ControlEnable(szTitle:WString,  szText:WString, szControl:WString):Int
    fun AU3_ControlEnableByHandle(hWnd:HWND ,  hCtrl:HWND ):Int
    fun AU3_ControlFocus(szTitle:WString,  szText:WString,  szControl:WString):Int
    fun AU3_ControlFocusByHandle(hWnd:HWND ,  hCtrl:HWND):Int
    fun AU3_ControlGetFocus(szTitle:WString, szText:WString, szControlWithFocus:LPWSTR, nBufSize:Int)
    fun AU3_ControlGetFocusByHandle(hWnd:HWND, szControlWithFocus:LPWSTR, nBufSize:Int)
    fun AU3_ControlGetHandle(hWnd:HWND, szControl:WString):HWND
    fun AU3_ControlGetHandleAsText(szTitle:WString, szText:WString, szControl:WString, szRetText:LPWSTR, nBufSize:Int);
    fun AU3_ControlGetPos(szTitle:WString, szText:WString, szControl:WString, lpRect: WinDef.RECT):Int
    fun AU3_ControlGetPosByHandle(hWnd:HWND, hCtrl:HWND, lpRect: WinDef.RECT):Int
    fun AU3_ControlGetText(szTitle:WString, szText:WString, szControl:WString, szControlText:LPWSTR, nBufSize:Int);
    fun AU3_ControlGetTextByHandle(hWnd:HWND, hCtrl:HWND, szControlText:LPWSTR, nBufSize:Int);
    fun AU3_ControlHide(szTitle:WString, szText:WString, szControl:WString):Int
    fun AU3_ControlHideByHandle(hWnd:HWND, hCtrl:HWND):Int
    fun AU3_ControlMove(szTitle:WString, szText:WString, szControl:WString, nX:Int, nY:Int, nWidth:Int = -1, nHeight:Int = -1):Int
    fun AU3_ControlMoveByHandle(hWnd:HWND, hCtrl:HWND, nX:Int, nY:Int, nWidth:Int = -1, nHeight:Int = -1):Int
    fun AU3_ControlSend(szTitle:WString, szText:WString, szControl:WString, szSendText:WString, nMode:Int = 0):Int
    fun AU3_ControlSendByHandle(hWnd:HWND, hCtrl:HWND, szSendText:WString, nMode:Int = 0):Int
    fun AU3_ControlSetText(szTitle:WString, szText:WString, szControl:WString, szControlText:WString):Int
    fun AU3_ControlSetTextByHandle(hWnd:HWND, hCtrl:HWND, szControlText:WString):Int
    fun AU3_ControlShow(szTitle:WString, szText:WString, szControl:WString):Int
    fun AU3_ControlShowByHandle(hWnd:HWND, hCtrl:HWND):Int
    fun AU3_ControlTreeView(szTitle:WString, szText:WString, szControl:WString, szCommand:WString, szExtra1:WString, szExtra2:WString, szResult:LPWSTR, nBufSize:Int);
    fun AU3_ControlTreeViewByHandle(hWnd:HWND, hCtrl:HWND, szCommand:WString, szExtra1:WString, szExtra2:WString, szResult:LPWSTR, nBufSize:Int);

    fun AU3_DriveMapAdd(szDevice:WString, szShare:WString, nFlags:Int, /*[in,defaultvalue("")]*/szUser:WString, /*[in,defaultvalue("")]*/szPwd:WString, szResult:LPWSTR, nBufSize:Int)
    fun AU3_DriveMapDel(szDevice:WString):Int
    fun AU3_DriveMapGet(szDevice:WString, szMapping:LPWSTR, nBufSize:Int)
    fun AU3_IsAdmin():Int
    fun AU3_MouseClick(/*[in,defaultvalue("LEFT")]*/szButton:WString, nX:Int = AU3_INTDEFAULT, nY:Int = AU3_INTDEFAULT, nClicks:Int = 1, nSpeed:Int = -1):Int
    fun AU3_MouseClickDrag(szButton:WString, nX1:Int, nY1:Int, nX2:Int, nY2:Int, nSpeed:Int = -1):Int
    fun AU3_MouseDown(/*[in,defaultvalue("LEFT")]*/szButton:WString)
    fun AU3_MouseGetCursor():Int
    fun AU3_MouseGetPos(lpPoint:POINT)
    fun AU3_MouseMove(nX:Int, nY:Int, nSpeed:Int = -1):Int
    fun AU3_MouseUp(/*[in,defaultvalue("LEFT")]*/szButton:WString)
    fun AU3_MouseWheel(szDirection:WString, nClicks:Int)
    fun AU3_Opt(szOption:WString, nValue:Int):Int
    fun AU3_PixelChecksum(lpRect:RECT, nStep:Int = 1):UInt
    fun AU3_PixelGetColor(nX:Int, nY:Int):Int
    fun AU3_PixelSearch(lpRect:RECT, nCol:Int, /*default 0*/nVar:Int, /*default 1*/nStep:Int, pPointResult:POINT)
    fun AU3_ProcessClose(szProcess:WString):Int
    fun AU3_ProcessExists(szProcess:WString):Int
    fun AU3_ProcessSetPriority(szProcess:WString, nPriority:Int):Int
    fun AU3_ProcessWait(szProcess:WString, nTimeout:Int = 0):Int
    fun AU3_ProcessWaitClose(szProcess:WString, nTimeout:Int = 0):Int
    fun AU3_Run(szProgram:WString, /*[in,defaultvalue("")]*/szDir:WString, nShowFlag:Int = SW_SHOWNORMAL):Int
    fun AU3_RunWait(szProgram:WString, /*[in,defaultvalue("")]*/szDir:WString, nShowFlag:Int = SW_SHOWNORMAL):Int
    fun AU3_RunAs(szUser:WString, szDomain:WString, szPassword:WString, nLogonFlag:Int, szProgram:WString, /*[in,defaultvalue("")]*/szDir:WString, nShowFlag:Int = SW_SHOWNORMAL):Int
    fun AU3_RunAsWait(szUser:WString, szDomain:WString, szPassword:WString, nLogonFlag:Int, szProgram:WString, /*[in,defaultvalue("")]*/szDir:WString, nShowFlag:Int = SW_SHOWNORMAL):Int
    fun AU3_Send(szSendText:WString, nMode:Int = 0)
    fun AU3_Shutdown(nFlags:Int):Int
    fun AU3_Sleep(nMilliseconds:Int)
    fun AU3_StatusbarGetText(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, /*[in,defaultvalue(1)]*/nPart:Int, szStatusText:LPWSTR, nBufSize:Int):Int
    fun AU3_StatusbarGetTextByHandle(hWnd:HWND, /*[in,defaultvalue(1)]*/nPart:Int, szStatusText:LPWSTR, nBufSize:Int):Int
    fun AU3_ToolTip(szTip:WString, nX:Int = AU3_INTDEFAULT, nY:Int = AU3_INTDEFAULT)
    fun AU3_WinActivate(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinActivateByHandle(hWnd:HWND):Int
    fun AU3_WinActive(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinActiveByHandle(hWnd:HWND):Int
    fun AU3_WinClose(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinCloseByHandle(hWnd:HWND):Int
    fun AU3_WinExists(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinExistsByHandle(hWnd:HWND):Int
    fun AU3_WinGetCaretPos(lpPoint:POINT):Int
    fun AU3_WinGetClassList(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinGetClassListByHandle(hWnd:HWND, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinGetClientSize(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, lpRect:RECT):Int
    fun AU3_WinGetClientSizeByHandle(hWnd:HWND, lpRect: WinDef.RECT):Int
    fun AU3_WinGetHandle(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):HWND
    fun AU3_WinGetHandleAsText(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinGetPos(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, lpRect:RECT):Int
    fun AU3_WinGetPosByHandle(hWnd:HWND, lpRect:RECT):Int
    fun AU3_WinGetProcess(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinGetProcessByHandle(hWnd:HWND):Int
    fun AU3_WinGetState(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinGetStateByHandle(hWnd:HWND):Int
    fun AU3_WinGetText(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinGetTextByHandle(hWnd:HWND, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinGetTitle(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinGetTitleByHandle(hWnd:HWND, szRetText:LPWSTR, nBufSize:Int)
    fun AU3_WinKill(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString):Int
    fun AU3_WinKillByHandle(hWnd:HWND):Int
    fun AU3_WinMenuSelectItem(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, szItem1:WString,
                              szItem2:WString, szItem3:WString, szItem4:WString,
                              szItem5:WString, szItem6:WString, szItem7:WString, szItem8:WString):Int
    fun AU3_WinMenuSelectItemByHandle(hWnd:HWND, szItem1:WString, szItem2:WString, szItem3:WString, szItem4:WString,
                                      szItem5:WString, szItem6:WString, szItem7:WString, szItem8:WString):Int
    fun AU3_WinMinimizeAll()
    fun AU3_WinMinimizeAllUndo()
    fun AU3_WinMove(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nX:Int, nY:Int, nWidth:Int = -1, nHeight:Int = -1):Int
    fun AU3_WinMoveByHandle(hWnd:HWND, nX:Int, nY:Int, nWidth:Int = -1, nHeight:Int = -1):Int
    fun AU3_WinSetOnTop(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nFlag:Int):Int
    fun AU3_WinSetOnTopByHandle(hWnd:HWND, nFlag:Int):Int
    fun AU3_WinSetState(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nFlags:Int):Int
    fun AU3_WinSetStateByHandle(hWnd:HWND, nFlags:Int):Int
    fun AU3_WinSetTitle(szTitle:WString,/*[in,defaultvalue("")]*/ szText:WString, szNewTitle:WString):Int
    fun AU3_WinSetTitleByHandle(hWnd:HWND, szNewTitle:WString):Int
    fun AU3_WinSetTrans(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nTrans:Int):Int
    fun AU3_WinSetTransByHandle(hWnd:HWND, nTrans:Int):Int
    fun AU3_WinWait(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nTimeout:Int = 0):Int
    fun AU3_WinWaitByHandle(hWnd:HWND, nTimeout:Int):Int
    fun AU3_WinWaitActive(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nTimeout:Int = 0):Int
    fun AU3_WinWaitActiveByHandle(hWnd:HWND, nTimeout:Int):Int
    fun AU3_WinWaitClose(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nTimeout:Int = 0):Int
    fun AU3_WinWaitCloseByHandle(hWnd:HWND, nTimeout:Int):Int
    fun AU3_WinWaitNotActive(szTitle:WString, /*[in,defaultvalue("")]*/szText:WString, nTimeout:Int):Int
    fun AU3_WinWaitNotActiveByHandle(hWnd:HWND, nTimeout:Int = 0):Int
}

