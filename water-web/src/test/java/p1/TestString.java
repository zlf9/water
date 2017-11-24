package p1;

import java.util.Arrays;

public class TestString {

	public static void main(String[] args) {
		String oldFormula = "[SH:80%][SY:10%][GY:10%]";
		oldFormula = oldFormula.replace("[", " ");
		oldFormula = oldFormula.replace("]", " ");
		System.out.println(oldFormula);
		String[] arr = oldFormula.split("  ");
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
