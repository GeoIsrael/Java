package telran.recursion.model;

import java.util.function.BiConsumer;

public class BSTree<K extends Comparable<K>, V> {
	private Node<K, V> root;                         //приватная нода родитель

	public void add(K key, V value) {
		root = addRecursion(root, key, value);
	}

	private Node<K, V> addRecursion(Node<K, V> node, K key, V value) {
		if (node == null) {
			node = new Node<K, V>(key, value);
			return node;
		}
		if (key.compareTo(node.key) < 0) {
			node.left = addRecursion(node.left, key, value);
		} else {
			node.right = addRecursion(node.right, key, value);
		}
		return node;
	}

	public boolean contains(K key) {
		// TODO
		return false;
	}

	public V get(K key) {
		// TODO
		return null;
	}

	public void traverse(BiConsumer<K, V> biConsumer) {
		// TODO
	}

	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> left;
		Node<K, V> right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

}
