# ConsoleGL v0.1.0a(25y33b)

This is Command Console.

## Run Console

#### run.bat
```batch
    @echo off
    cls
    java -jar <File> nogui
    exit
```

## Add Command(after v0.1.1a)

in source code,
#### src/net/godlights/edshin/java/console/cmd/CommandTest.java
```java
    package net.godlights.edshin.java.console.cmd;

    public class CommandTest implements CmdExecutor{
        @Override
        public boolean onCmd(String[] args) {
            //code
            return false;
        }
    }
```

and write in console

```console
    > cmd <CommandName>
    
    > <CommandName> <..args>
```


