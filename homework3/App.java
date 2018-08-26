package ru.geekbrains.antonelenberger.homework3;
import java.io.File;
import static ru.geekbrains.antonelenberger.homework3.FileMethods.MethodsToWorkWithFiles.*;

/**
 * @author Anton Elenberger
 */

public class App {
    public static void main(String[] args) {
        System.out.println("First task");
        File target50ByteFile = new File("target50ByteFile.txt");
        target50ByteFile.deleteOnExit();
        String text50BytesExmp = "So i just happen to be living in Tyumen, not as rich as you might think.";
        writeFileMethod(text50BytesExmp, target50ByteFile);
        System.out.println("Прочтем файл");
        readByteFileMethod(target50ByteFile);
        System.out.println("--------------");

        System.out.println("Second Task");
        File firstFile = new File("Firstfile.txt");
        File secondFile = new File("Secondfile.txt");
        File thirdFile = new File("Thirdfile.txt");
        File fourthFile = new File("Fourthfile.txt");
        File fifthFile = new File("Fifthfile.txt");
        writeFileMethod(text50BytesExmp,firstFile);
        writeFileMethod(text50BytesExmp,secondFile);
        writeFileMethod(text50BytesExmp,thirdFile);
        writeFileMethod(text50BytesExmp,fourthFile);
        writeFileMethod(text50BytesExmp,fifthFile);
        File targetConnected = new File("Conneted.txt");
        concatenateFiles(targetConnected, firstFile, secondFile, thirdFile, fourthFile, fifthFile);
        System.out.println("---------------");

        System.out.println("Third Task");
        File fileForThirdTask = new File("Third_task_file.txt");
        fileForThirdTask.deleteOnExit();
        writeThirdTaskFile(1800, 3000, fileForThirdTask);
        readThirdTaskFile();
    }
}
