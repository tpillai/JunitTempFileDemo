# JunitTempFileDemo

There are 2 files under https://github.com/tpillai/JunitTempFileDemo/tree/main/src/test/resources/zipTest
test1.txt
test2.txt

ZipMultipleFiles : Zips the file in "src/test/resources/zipTest" and copies to "src/test/resources/multiCompressed.zip"

In order to Test above functionality , we use Junit TempFolder
ZipMultiFileTest is used for testing the class ZipMultipleFiles.

ZipMultipleFiles does below actions
1. Create a Temp folder

2. Copies test1.txt and test2.txt to Temp Folder
finalFile1Path=contains path to test1.txt in Temp folder
finalFile2Path= contians path to test2.tx in Temp folder

3. outputFile contians the path to Zip file (multiCompressed) in Temp folder

4. Calls  ZipMultipleFiles.zipfile(finalFile1Path,finalFile2Path,outputFile);
5. Checks that outFile is actually created
6. After running the Junit, the temp folder is automatically deleted
