package sample.nativedriver;

import junit.framework.TestCase;

import org.openqa.selenium.By;

import com.google.android.testing.nativedriver.client.AndroidNativeDriver;
import com.google.android.testing.nativedriver.client.AndroidNativeDriverBuilder;
import com.google.android.testing.nativedriver.client.AndroidNativeElement;
import com.google.android.testing.nativedriver.common.AndroidNativeBy;

public abstract class NativedriverTestCase extends TestCase {
	protected AndroidNativeDriver driver;

    @Override
	protected void setUp() throws Exception {
    	driver = new AndroidNativeDriverBuilder().withDefaultServer().build();
	}

	@Override
	protected void tearDown() throws Exception {
		driver.quit();
	}

	protected AndroidNativeElement findElementById(String id) {
		return findElement(By.id(id));
	}

	protected AndroidNativeElement findElementByText(String text) {
		return findElement(AndroidNativeBy.text(text));
	}

	protected AndroidNativeElement findElementByName(String name) {
		return findElement(AndroidNativeBy.name(name));
	}

	protected void startActivity(String activityName) {
		driver.startActivity(activityName);
	}

	protected void back() {
		driver.navigate().back();
	}

	private AndroidNativeElement findElement(By by) {
		return driver.findElement(by);
	}

}
