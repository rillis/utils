# FileUtils
*com.github.rillis.Files* 
  
  
**Methods**  
```java
//Create file/folder (and parent folders) and doesn't exists. Returns file it self.
create(File file) : File throws IOException
create(File[] file) : void throws IOException

//Delete file/folder and any subdirectory.
delete(File file) : void
delete(File[] file) : void

//Rename file. Return renamed file.
rename(File file) : File

//Move file. Return destination file.
move(File file, File destFile) : File throws IOException

//Copy file.
copy(File file, File destFile) : void throws IOException

//Remove any Illegal char for file creation (Windows) from a String
removeIllegalChars(String str) : String

//Write a string in a file
write(File file, String str) : void throws IOException

//Write a string in a file (append mode)
writeAppend(File file, String str, boolean newLine) : void throws IOException

//Reads a file to string
read(File file) : String throws FileNotFoundException, IOException
```

**Constants**