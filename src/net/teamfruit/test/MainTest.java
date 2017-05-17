package net.teamfruit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

	private final StandardInputSnatcher in = new StandardInputSnatcher();

	@Before
	public void before() {
		System.setIn(this.in);
	}

	@After
	public void after() {
		System.setIn(null);
	}

	@Test
	public void test() {
		this.in.inputln("3");
		this.in.inputln("6 1 8");
		this.in.inputln("7 5 3");
		this.in.inputln("2 0 0");

		try {
			tabidachimachi_funke.ikenie.yotonokeiyaku.Main.main(null);
		} catch (final Exception e) {
		}
	}
}
