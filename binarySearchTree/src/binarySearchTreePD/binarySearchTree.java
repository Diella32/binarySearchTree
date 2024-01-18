package binarySearchTreePD;

import java.util.ArrayList;
import java.util.Comparator;

public class binarySearchTree<E, K extends Comparable<K>> {
	Node <E,K> root; 

	private class Node<E,K>{
		K key; 
		E element; 
		Node <E,K> parent;
		Node <E,K> leftChild;
		Node <E,K> rightChild;
		
		//TODO: add parent, left and right children
				
		public Node(K keyUsed, E elementUsed){
			key = keyUsed;
			element = elementUsed; 
		}
		
		public void setKey(K keyUsed) {
			key = keyUsed;
		}
		
		public K getKey() {
			return key; 
		}
		public E getElement() {
			return element;
		}
		public void setElement(E elementUsed) {
			element = elementUsed; 
		}		
		
		public Node<E,K> getParent() {
			return parent;
		}	
		public void setParent(Node <E,K> parentUsed) {
			parent = parentUsed; 
		}
		
		public Node<E,K> getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(Node <E,K> leftChildUsed) {
			leftChild = leftChildUsed; 
		}
		public Node<E,K> getRightChild() {
			return rightChild;
		}
		public void setRightChild(Node <E,K> rightChildUsed) {
			rightChild = rightChildUsed; 
		}
		
	}
	
	public binarySearchTree() {
		root = null;
	}
	
	public void insert(E value, K keyUsed){
		Node <E,K> elementUsed = new Node<E,K>(keyUsed,value);
		
		if(root == null) {
			root = elementUsed;
		}
		else {
			Node <E,K> parent = findParent(keyUsed, root);
			
			elementUsed.setParent(parent);
			
			if(keyUsed.compareTo(parent.getKey())<0) {
				parent.setLeftChild(elementUsed);
			}
			else {
				parent.setRightChild(elementUsed);
			}
		}
		
	}
	
	private Node<E,K> findParent(K key, Node<E,K> current) {
		if(key.compareTo(current.getKey()) < 0) {
			if(current.getLeftChild() == null) {
				return current;
			}
			else {
				return findParent(key, current.getLeftChild());
			}
		}
		else {
			if(current.getRightChild() == null) {
				return current;
			}
			else {
				return findParent(key, current.getRightChild());
			}
		}
	}
	
	public E search(K keyUsed){
		Node<E,K> entry = findEntry(keyUsed, root);
		
		if(entry==null) {
			return null; 
		}
		else {
			return entry.getElement();
		}
	}
	
	private Node<E,K> findEntry(K key, Node<E,K> current) {
		// si c'est vide, return null
		if(current == null) {
			return null;
		}
		// if it's the first one que on tombe sur, return it
		else if(key.compareTo(current.getKey()) == 0) {
			return current;
		}
		//si c'est moin que le current, go to the left, and by recursion, find the left child that matches
		else if(key.compareTo(current.getKey()) < 0) {
			return findEntry(key, current.getLeftChild());	
		}
		//si c'est moin que le current, go to the left, and by recursion, find the right child that matches
		else {
			return findEntry(key, current.getRightChild());
		}
	}
	
	public E remove(K keyUsed) {
		Node<E,K> entry = findEntry(keyUsed, root);
		
		if(entry==null) {
			return null; 
		}
		else {
			E element = entry.getElement();
			
			if (entry.getLeftChild() == null && entry.getRightChild() == null) {
				if(root == entry) {
					root = null; 
				}
				else {
					if(entry.getParent().getLeftChild() == entry) {
						entry.getParent().setLeftChild(null);//umwana w'ibumoso umukureho 
					}
					else {
						entry.getParent().setRightChild(null);//iburyo 
					}
				}
			}
			// ifite umwana w'ibumoso
			else if (entry.getRightChild() == null) {
				if(root == entry) {
					root = entry.getLeftChild(); // set left child , remplace
					entry.getLeftChild().setParent(null);// break umubyeyi
				}
				else {
					entry.getLeftChild().setParent(entry.getParent()); // change umubyeyi  
					
					if(entry.getParent().getLeftChild() == entry) {// 
						entry.getParent().setLeftChild(entry.getLeftChild());// change 
					}
					else {
						entry.getParent().setRightChild(entry.getLeftChild());// change 
					}
				}
			}
			else if (entry.getLeftChild() == null) {
				if(root == entry) {
					root = entry.getRightChild(); 
					entry.getRightChild().setParent(null);
				}
				else {
					entry.getRightChild().setParent(entry.getParent());
					
					if(entry.getParent().getLeftChild() == entry) {
						entry.getParent().setLeftChild(entry.getRightChild());
					}
					else {
						entry.getParent().setRightChild(entry.getRightChild());
					}
				}
			}
			else {
				Node<E,K> successor = findLeftMostChild(entry.getRightChild());
				
				//removing entry
				entry.setElement(successor.getElement());
				entry.setKey(successor.getKey());
				
				//removing duplicate data
				if(successor.getParent().getLeftChild() == successor) {
					successor.getParent().setLeftChild(successor.getRightChild());
				}
				else {
					successor.getParent().setRightChild(successor.getRightChild());
				}
				
				if(successor.getRightChild() != null) {
					successor.getRightChild().setParent(successor.getParent()); 				
				}
				
			}
			
			return element;
		}

}
	private Node<E,K> findLeftMostChild(Node<E,K> current) {
		if(current.getLeftChild() == null) {
			return current;
		}
		else {
			return findLeftMostChild(current.getLeftChild()); 
		}
	}

	
	private Node<E,K> findTheOneAfter(Node<E,K> root){
		while(root.leftChild != null) {
			root = root.leftChild;
		}
		return root;
	}
	public int height() {
		return height(root);
	}
	
	
	public int height(Node<E,K> p) {
		 int h = 0; 
		 for (Node<E,K> c : children(p))
			 h = Math.max(h, 1 + height(c));
		 return h;
		 }
	public ArrayList<Node> children(Node<E,K> tree){
		
		ArrayList<Node> treeUsed = new ArrayList<Node>();
		
		if(tree.leftChild != null) {
			treeUsed.add(tree.leftChild); 
		}
		if (tree.rightChild != null) {
			treeUsed.add(tree.rightChild); 

		}
		return treeUsed; 
	}
	
}
