
public class TestString {

	public static void main(String[] args) {
		String s1= "尊敬的用户{用户姓名}，您好。你户已欠缴水费 {欠费金额} 元，请在三天内至我公司收费大厅结清水费，否则将停止供水。";
		
		
		System.out.println(s1.replace("{用户姓名1}", "zs"));
	}
}
