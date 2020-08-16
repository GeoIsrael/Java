package telran.recursion.model;

import java.util.function.BiConsumer;

public class BSTree<K extends Comparable<K>, V> {
	private Node<K, V> root;

	public void add(K key, V value) {
		if (root == null) {
			root = new Node<>(key, value);
		} else {
			add(root, key, value);
		}
	}

	private void add(Node<K, V> node, K key, V value) {
		if (key.compareTo(node.key) < 0) {
			if (node.left == null) {
				node.left = new Node<>(key, value);
			} else {
				add(node.left, key, value);
			}
		} else {
			if (node.right == null) {
				node.right = new Node<>(key, value);
			} else {
				add(node.right, key, value);
			}
		}

	}

//	public void add(K key, V value) {
//		root = addRecursion(root, key, value);
//	}
//
//	private Node<K, V> addRecursion(Node<K, V> node, K key, V value) {
//		if (node == null) {
//			node = new Node<K, V>(key, value);
//			return node;
//		}
//		if (key.compareTo(node.key) < 0) {
//			node.left = addRecursion(node.left, key, value);
//		} else {
//			node.right = addRecursion(node.right, key, value);
//		}
//		return node;
//	}

	public boolean contains(K key) {
		return search(root, key) != null;
	}

	public V get(K key) {
		Node<K, V> node = search(root, key);
		return node == null ? null : node.value;
	}

	private Node<K, V> search(Node<K, V> node, K key) {
		if (node == null || node.key.compareTo(key) == 0) {
			return node;
		}
		if (key.compareTo(node.key) < 0) {
			return search(node.left, key);
		} else {
			return search(node.right, key);
		}
	}

	public void traverse(BiConsumer<K, V> biConsumer) {
		traverseInfix(root, biConsumer);
	}

	private void traverseInfix(Node<K, V> node, BiConsumer<K, V> biConsumer) {
		if (node != null) {
			traverseInfix(node.left, biConsumer);
			biConsumer.accept(node.key, node.value);
			traverseInfix(node.right, biConsumer);
		}	
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
