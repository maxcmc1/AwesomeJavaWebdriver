package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class InterviewExer {

    @Test
    public void test_001() {

            for (int i = 1; i <= 11; i++) {

                if (i%2!=0) System.out.println(i);
            }

    }

    @Test
    public void swapTwoNumbersInArray_001() {
        int[] array = {1,2,3,4};
        swap(array, 0, 2);
        System.out.println(Arrays.toString(array));

    }

    private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;

    }

    @Test
    public void testCountLetters() {
        String input = "$hello world";
        int actualResult = getNumbersOfLetters(input, '$');
        int expectedResult = 1;

        Assert.assertEquals(actualResult, expectedResult);
    }

    private int getNumbersOfLetters(String input, char letter) {
        int result = 0;

        char[] inputAsArray =  input.toCharArray();

        for(char eachChar : inputAsArray){
            if(eachChar== letter) result++;
        }
        return result;
    }


}
