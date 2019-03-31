package day5;

import day4.BaseTest;
import org.testng.annotations.Test;

public class XpathTests extends BaseTest {

    @Test
    public void test001() {
        String restID_CSS = "div.MuiFormControl-root-96:nth-child(2) > div:nth-child(2) > input:nth-child(1)";
        String restID_XPath = "/html/body/div/div/form/div/div[1]/div/input"; //absolute Xpath (single slash)
        String restID_XPath2 = "//form/div/div[1]/div/input"; // double slash Xpath (Relative Xpath)
        String restID_Xpath3 = "//input[@name='restaurant_id']"; //   "//<HTMLtag>[@attribute_name='attribute_value']" (single attribute with tag)
        String restID_Xpath4 = "//*[@name='restaurant_id']"; //   "//*[@attribute_name='attribute_value']" (single attribute with asterisk)
        String restID_Xpath5 = "//*[@name='restaurant_id'][@type='text']"; //   "//*[@attribute_name1='attribute_value1'][@attribute_name2='attribute_value2']" (multiple attribute)
        String restID_Xpath6 = "//*[@name='restaurant_id' and @type='text']"; //  "//*[@attribute_name1='attribute_value1' and @attribute_name2='attribute_value2']"
        String restID_Xpath7 = "//*[@name='restaurant_id' or @type='text12345']"; //  "//*[@attribute_name1='attribute_value1' or @attribute_name2='attribute_value2']"
        String restID_Xpath8 = "//*[contains(@name,'rest')]"; // //*[contains(@attribute_name,'attribute_value')]
        String restID_Xpath9 = "//*[starts-with(@name,'rest')]"; // //[*starts-with(@attribute_name,'attribute_value')]
        String restID_Xpath10 = "//*[text()='Log In']"; //  //*[text()='Log In']
        String restID_Xpath11 = "(//input[@type='text'])[last()-1]";  // //input[@type='text'])[last()-1]
        String restID_Xpath12 = "(//*[@type='text'])[position()=2]"; //  //*[@type='text'])[position()=2]" (position)
        String restID_Xpath13 = "//input[1]"; //Finding elements using index

        String url = "http://52.9.182.211:3001/v1/log-in";

        openPage(url);


    }
}
