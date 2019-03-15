package day4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CodeEx1 {

    // given a string
    // check if string is a Palyndrome
    // madam

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "madam" },
                { "gkgdskh" },
        };
    }

    @Test(dataProvider = "test1")
    public void testPalyndromeWithDP(String input) {
        Boolean result = isPalyndrome(input);
        Assert.assertTrue(result);

    }

    @Test
    public void testPalyndrome001() {
        String input = "madam";
        Boolean result;

        result = isPalyndrome(input);
        Assert.assertTrue(result);

    }

    @Test
    public void testPalyndrome002() {
        String input = "gkgdskh";
        Boolean result;

        result = isPalyndrome(input);
        Assert.assertTrue(result);

    }




    private Boolean isPalyndrome(String input) {
        boolean result;
        String reversedInput = reverceInput(input);
        result = input.equals(reversedInput);
        return result;
    }

    private String reverceInput(String input) {
        return new StringBuffer(input).reverse().toString();
    }

}
