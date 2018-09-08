package ru.geekbrains.anronelenberger.homework6;

/**
 * @author Anton Elenberger
 */

public class MainClass {
       public static void main(String[] args) {

    }

    public static int[] task1(int... input) throws RuntimeException {
        int start = input.length;

        for(int i = input.length - 1; i >= 0; i--) {
            if(input[i] == 4) {
                start = i;
                break;
            }
        }
        if(start == input.length){
            throw new RuntimeException("No 4 in input array");
        }
        int[] output = new int[input.length - start - 1];
        for(int i = start + 1; i < input.length; i++) {
            output[i - start - 1] = input[i];
        }
        return output;
    }

    public static boolean task2(int... input) {
        boolean mark = false;
        for (int anInput : input) {
            if (anInput == 1 || anInput == 4) {
                mark = true;
            } else return false;
        }
        return mark;
    }
}
