package ru.geekbrains.antonelenberger.homework3.FileMethods;
import java.io.*;
import java.util.*;

public class MethodsToWorkWithFiles {
    public static Scanner scanner;

    public static void writeFileMethod(String source, File targetFile) {
        try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile))) {
            out.write(source.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  readByteFileMethod(File source) {
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
            byte[] inputArray = new byte[128];
            int chek;
            while ((chek = in.read(inputArray)) != -1) {
                System.out.println(Arrays.toString(inputArray));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  concatenateFiles(File target, File...filenames) {
        List<BufferedInputStream> filesSources = new ArrayList<>();
        try {
            for(File f : filenames) {
                filesSources.add(new BufferedInputStream(new FileInputStream(f)));
            }
            try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target));
                SequenceInputStream sin = new SequenceInputStream(Collections.enumeration(filesSources))) {
                int chek;
                while ((chek = sin.read()) != -1) {
                    out.write(chek);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readThirdTaskFile() {
        scanner = new Scanner(System.in);
        System.out.print("FIle name: ");
        String filename = scanner.next();
        int pageSize = 1800;
        while (!"exit".equals(scanner.nextLine())) {
            System.out.print("Page number: ");
            int pageNumber = scanner.nextInt();
            if(pageNumber == -1) {
                scanner.close();
                break;
            }

            long startTime = System.currentTimeMillis();
            try(RandomAccessFile r = new RandomAccessFile(filename, "r")) {
                int startingPos = (pageNumber - 1) * pageSize;
                r.seek(startingPos);
                int counter = 0;
                while (r.getFilePointer() != (startingPos + pageSize)) {
                    System.out.println(r.read());
                    r.seek(startingPos + (++counter));
                }
                System.out.println("\nTime count for search and read: " + (System.currentTimeMillis() - startTime) + "ms");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeThirdTaskFile(int pageSize, int pageCuontity, File target) {
        try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target))) {
            for(int i = 0; i < pageCuontity; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                int fill = i % 10;
                for(int j = 0; j < pageSize; j++) {
                    stringBuilder.append(fill);
                }
                out.write(stringBuilder.toString().getBytes());
                out.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
