package datastructures.test;
import static org.junit.Assert.*;

import org.junit.rules.Timeout;

import datastructures.Queue;

import org.junit.Rule;
import org.junit.Test;

public class QueueTest {

	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);

	@Test
	public void custom() {
		Queue<String> ll = new Queue<String>();
		ll.enqueue("3");
		ll.enqueue("1");

		assertEquals("3", ll.dequeue());
		assertEquals("1", ll.dequeue());

	}

	@Test
	public void testAddLastEasy() {
		Queue<String> ll = new Queue<String>();
		ll.enqueue("asdf");
		ll.enqueue("11");
		assertEquals("asdf", ll.dequeue());
		assertEquals(1, ll.getSize());

		ll.enqueue("42");
		assertEquals("11", ll.dequeue());
		assertEquals("42", ll.dequeue());
		assertEquals(0, ll.getSize());

		ll.enqueue("57");
		assertEquals("57", ll.dequeue());
		assertEquals(null, ll.dequeue());
		assertEquals(0, ll.getSize());
	}

}
