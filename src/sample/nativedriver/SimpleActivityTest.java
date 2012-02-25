package sample.nativedriver;
import com.google.android.testing.nativedriver.client.AndroidNativeElement;
import com.google.android.testing.nativedriver.common.AndroidKeys;
 
public class SimpleActivityTest extends NativedriverTestCase {

    public void testSubActivity() {
    	startActivity("sample.nativedriver.SimpleActivity");

    	AndroidNativeElement editName = findElementById("edit_name");
    	editName.sendKeys("yyhayashi303");
    	AndroidNativeElement editAge = findElementById("edit_age");
    	// フォーカスを当てるためにクリックする必要がある
    	editAge.click();
    	editAge.sendKeys("27");
    	driver.getKeyboard().sendKeys(AndroidKeys.ENTER);
    	findElementById("transit_next").click();
    	assertEquals("yyhayashi303さんは成人です。", findElementById("profile").getText());
    }
}
