
public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	private static boolean root=true;
	public static final AVLTree NIL = new AVLTree();
	public AVLTree(int key){
		this.key=key;
		left=right =NIL;
	}
	private AVLTree(){
		left=right=this;
		height = -1;
	}
	
	private AVLTree(int key, AVLTree left, AVLTree right){
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}
	public int size(){
		if(this == NIL)
			return 0;
		return 1+left.size()+right.size();
	}
	public String toString(){
		if(this == NIL)
			return "";
		return left+" "+key+" "+right;
	}
	public boolean add(int key){
		int oldsize = size();
		grow(key);
		return size()>oldsize;
	}
	public AVLTree delete(int key){
		AVLTree current = this;
		if(this == NIL)
			return null;
		if(this.key == key){
			if(this.left == NIL && this.right == NIL){
				return NIL;
			}
			else if(this.left == NIL){
				return this.right;
			}
			else if(this.right == NIL){
				return this.left;
			}
			else if(this.left != NIL && this.right != NIL){
				AVLTree leftMax = this.MaxRight(this);
				if(root){
					leftMax.right = current.right;
					current = leftMax;
					this.key = current.key;
					this.left = current.left;
					this.right = current.right;
					return this;
				}
				else{
					leftMax.right = current.right;
					return leftMax;
				}
			}
		}
		root = false;
		if(this.key>key){
			if(this.left == NIL)
				return NIL;
			left = left.delete(key);
			
		}
		else if(this.key<key){
			if(this.right==NIL)
				return NIL;
			right = right.delete(key);
		}
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		root = true;
		return this;
	}
	private AVLTree MaxRight(AVLTree t){
		AVLTree successor = null;
		AVLTree successorParent = null;
		AVLTree current = t.left;
		
		while(current != NIL){
			successorParent = successor;
			successor = current;
			current = current.right;
		}
		if(successor != t.left){
			successorParent.right = successor.left;
			successor.left = t.left;
		}
		return successor;
	}

	public AVLTree grow(int key){
		if(this == NIL)
			return new AVLTree(key);
		if(key == this.key)
			return this;
		if(key<this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}
	private void rebalance(){
		if(right.height > left.height+1){
			if(right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		}
		else if(left.height > right.height + 1){
			if(left.right.height > left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}
	private void rotateLeft(){
		left = new AVLTree(key,left,right.left);
		key = right.key;
		right = right.right;
	}
	private void rotateRight(){
		right = new AVLTree(key,left.right,right);
		key = left.key;
		left = left.left;
	}

}
