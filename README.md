# autoitjavabinding
Provide windows Automation using Autoit. It also provides framework for manipulating other process' memory. It is useful for game hacking.

# Building

It is a simple Kotlin/java project, a gradle jar will work.

```bash
$ gradle jar
```


# Using

Check Main.kt for example. In simple terms:
```kotlin
val au3: AutoitX = AutoitXLoader.loadAutoit3X64()
au3.AU3_MouseMove(128, 256)
au3.AU3_MouseClick(WString("left"))
```


#Disclaimer
I have not fully tested. It should work as expected.

