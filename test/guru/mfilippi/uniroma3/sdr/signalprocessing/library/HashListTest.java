package guru.mfilippi.uniroma3.sdr.signalprocessing.library;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class HashListTest {

	@Test
	public void test() {
			List<Integer> l = new LinkedList<>();
			l.set(100, 0);
			assertEquals(l.size(), 1);
	}

}
