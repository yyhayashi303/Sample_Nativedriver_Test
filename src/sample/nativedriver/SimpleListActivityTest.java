package sample.nativedriver;

public class SimpleListActivityTest extends NativedriverTestCase {

	public void testOnItemClick() {
		startActivity("sample.nativedriver.SimpleListActivity");

		String[] array = new String[] {
				"java",
				"javascript",
				"python",
				"ruby",
				"perl",
				"scala"};
		for (String text : array) {
			// 指定リストをクリック
			findElementById("list").findElementByText(text).click();
			// 少し待たないと書きのチェックでselectedの値が取得できない...
			w(200);
			// 選択されたアイテムが正しいかチェック
			assertEquals(text, findElementById("selected").getText());
		}
	}

	private void w(long time) {
		synchronized (this) {
			try {
				wait(time);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
