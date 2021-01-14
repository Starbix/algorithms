package datastructures.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.rules.Timeout;

import datastructures.DoublyLinkedList;
import datastructures.Node;

import org.junit.Rule;
import org.junit.Test;

public class LinkedListTest {

	@Rule
	public Timeout globalTimeout= Timeout.seconds(5);

	@Test
	public void custom() {
		DoublyLinkedList<String> ll = new DoublyLinkedList<String>();
		ll.addLast("3");
		ll.addLast("1");

		try {
			ll.get(2);
		} catch (Exception e) {
			assertEquals(true, e instanceof NoSuchElementException);
		}

	}

	@Test
	public void testAddLastEasy() {
		DoublyLinkedList<String> ll = this.<String>createMyList();
		ll.addLast("11");
		assertEquals("11", ll.get(0));
		assertEquals(1, ll.getSize());
		assertConsistency(ll);

		ll.addLast("42");
		assertEquals("11", ll.get(0));
		assertEquals("42", ll.get(1));
		assertEquals(2, ll.getSize());
		assertConsistency(ll);

		ll.addLast("57");
		assertEquals("11", ll.get(0));
		assertEquals("42", ll.get(1));
		assertEquals("57", ll.get(2));
		assertEquals(3, ll.getSize());
		assertConsistency(ll);
	}



	@Test
	public void testRandom() {
		Random rand = new Random(42);
		DoublyLinkedList<String> ll = this.<String>arrayToList(zero);
		for(int n = 0; n < 9721; n++) {
			int choice = rand.nextInt(6);
			int intValue = rand.nextInt();
			String value = Integer.toString(intValue);

			if(choice == 0)
				ll.addFirst(value);
			else if(choice == 1)
				ll.addLast(value);
			else if(choice == 2 && !ll.isEmpty())
				ll.removeFirst();
			else if(choice == 3 && !ll.isEmpty())
				ll.removeLast();
			else if(choice == 4 && !ll.isEmpty())
				ll.set(rand.nextInt(ll.getSize()), value);
			else if(choice == 5 && intValue % 5 == 0)
				ll.clear();
		}

		String msg = "There is a bug in your List";
		assertFalse(msg, ll.isEmpty());
		assertEquals(msg, 5, ll.getSize());
		String[] expect = new String[]{"-1759285598", "-424345731",
				"-1746103561", "-1623993329", "-1831395423"};
		this.<String>myAssertEquals(expect, ll);
	}

	String[] zero = { };
	String[] one = { "42" };
	String[] two = { "3", "1" };
	String[] three = { "2", "7", "1" };

	@Test
	public void testGet() {
		assertEquals("42", arrayToList(one).get(0));

		DoublyLinkedList<String> ll = arrayToList(two);
		assertEquals("3", ll.get(0));
		assertEquals("1", ll.get(1));

		ll = arrayToList(three);
		assertEquals("2", ll.get(0));
		assertEquals("7", ll.get(1));
		assertEquals("1", ll.get(2));
		assertEquals(3, ll.getSize());
	}

	@Test
	public void testSet() {
		DoublyLinkedList<String> ll = arrayToList(one);
		ll.set(0, "11");
		assertEquals("11", ll.get(0));

		ll = arrayToList(two);
		ll.set(1, "11");
		myAssertEquals(new String[] { "3", "11" }, ll);
		ll.set(0, "12");
		myAssertEquals(new String[] { "12", "11" }, ll);

		ll = arrayToList(three);
		ll.set(0, "0");
		ll.set(1, "1");
		ll.set(2, "2");
		myAssertEquals(new String[] { "0", "1", "2" }, ll);
		assertEquals(3, ll.getSize());

	}

	@Test
	public void testIsEmpty() {
		assertEquals(true,  arrayToList(zero).isEmpty());
		assertEquals(false, arrayToList(one).isEmpty());
		assertEquals(false, arrayToList(three).isEmpty());
	}

	@Test
	public void testAddFirst() {
		DoublyLinkedList<String> ll = arrayToList(zero);
		ll.addFirst("11");
		assertEquals("11", ll.get(0));
		assertEquals(1, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.addFirst("11");
		myAssertEquals(new String[] { "11", "42" }, ll);
		assertEquals(2, ll.getSize());
		assertConsistency(ll);
		ll.addFirst("12");
		myAssertEquals(new String[] { "12", "11", "42" }, ll);
		assertEquals(3, ll.getSize());
		assertConsistency(ll);
	}

	@Test
	public void testAddLast() {
		DoublyLinkedList<String> ll = arrayToList(zero);
		ll.addLast("11");
		assertEquals("11", ll.get(0));
		assertEquals(1, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.addLast("11");
		myAssertEquals(new String[] { "42", "11" }, ll);
		assertEquals(2, ll.getSize());
		assertConsistency(ll);
		ll.addLast("12");
		myAssertEquals(new String[] { "42", "11", "12" }, ll);
		assertEquals(3, ll.getSize());
		assertConsistency(ll);
	}

	@Test
	public void testRemoveFirst() {
		DoublyLinkedList<String> ll = arrayToList(one);
		assertEquals("42", ll.removeFirst());
		assertEquals(0, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(three);
		assertEquals("2", ll.removeFirst());
		assertEquals(2, ll.getSize());
		assertConsistency(ll);
		assertEquals("7", ll.removeFirst());
		assertEquals(1, ll.getSize());
		assertConsistency(ll);
		assertEquals("1", ll.removeFirst());
		assertEquals(0, ll.getSize());
		assertConsistency(ll);
	}

	@Test
	public void testRemoveLast() {
		DoublyLinkedList<String> ll = arrayToList(one);
		assertEquals("42", ll.removeLast());
		assertEquals(0, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(three);
		assertEquals("1", ll.removeLast());
		assertEquals(2, ll.getSize());
		assertConsistency(ll);
		assertEquals("7", ll.removeLast());
		assertEquals(1, ll.getSize());
		assertConsistency(ll);
		assertEquals("2", ll.removeLast());
		assertEquals(0, ll.getSize());
		assertConsistency(ll);
	}

	@Test
	public void testClear() {
		DoublyLinkedList<String> ll = arrayToList(zero);
		ll.clear();
		assertEquals(0, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(one);
		ll.clear();
		assertEquals(0, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(two);
		ll.clear();
		assertEquals(0, ll.getSize());
		assertConsistency(ll);

		ll = arrayToList(three);
		ll.clear();
		assertEquals(0, ll.getSize());
		assertConsistency(ll);
	}

	@Test
	public void testAddAll() {
		DoublyLinkedList<String> a = arrayToList(zero);
		DoublyLinkedList<String> b = arrayToList(two);
		a.addAll(b);
		myAssertEquals(two, a);

		a = arrayToList(two);
		b = arrayToList(zero);
		a.addAll(b);
		myAssertEquals(two, a);

		a = arrayToList(two);
		b = arrayToList(two);
		a.addAll(b);
		myAssertEquals(new String[] {"3", "1", "3", "1"}, a);
	}

	@Test
	public void testToArray() {
		DoublyLinkedList<String> ll = arrayToList(zero);
		myAssertEquals(new String[]{}, ll);
		myAssertEquals(one, arrayToList(one));
		myAssertEquals(two, arrayToList(two));
		myAssertEquals(three, arrayToList(three));
	}

	private <T> DoublyLinkedList<T> createMyList() {
		return new DoublyLinkedList<T>();
	}


	private <T> DoublyLinkedList<T> arrayToList(T[] elems) {
		DoublyLinkedList<T> res = this.<T>createMyList();


		for (int i = 0; i < elems.length; i++) {
			res.addLast(elems[i]);
		}

		return res;
	}

	private <T> void myAssertEquals(T[] expected, DoublyLinkedList<T> actual) {
		assertEquals(expected.length, actual.getSize());
		for (int i = 0; i < expected.length; i += 1) {
			assertEquals(expected[i], actual.get(i));
		}

	}

	private <T> void assertConsistency(DoublyLinkedList<T> ll) {

		int n = ll.getSize();

		if (n > 0) {

			ArrayList<Node<T>> seperateNodes = new ArrayList<Node<T>>(n);
			for (int i = 0; i < n; i += 1) {
				Node<T> node = ll.getNode(i);
				T value = ll.get(i);
				assertEquals(value, node.getKey());
				seperateNodes.add(i, node);
			}

			int i = 0; 
			Node<T> current = ll.getNode(0);
			assertTrue(seperateNodes.get(i) == current);
			i += 1;
			while(current.hasNext()) {
				current = current.next();
				assertTrue(seperateNodes.get(i) == current);
				i += 1;
			}
			assertEquals(n, i);

			i = 0;
			Iterator<T> iterator = ll.iterator();
			while (iterator.hasNext()) {
				T value = iterator.next();
				assertEquals(seperateNodes.get(i).getKey(), value);
				i += 1;
			}
			assertEquals(n, i);
		}
	}

}
