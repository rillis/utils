# CMD
*com.github.rillis.Windows*   
  
  
**Methods**   
```java
//Dispach command to cmd.exe, if waitFor = true then wait for command ends.
dispachCommand(String cmd, boolean waitFor) : Process throws IOException, InterruptedException 

//Get response of a command as String
getResponse(Process process) : String throws IOException
```

**Constants**  