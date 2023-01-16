package 浮点数注意事项;

import java.math.BigDecimal;
import java.math.MathContext;

public class B {
	public static void main(String[] args) {
		BigDecimal a = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(6), new MathContext(100));
		System.out.println(a);
	}
}
