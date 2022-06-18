
public class BST<E extends Comparable<E>> {

	class Node {
		protected E data;
		protected Node left, right;

		public Node(E data) {
			this(data, null, null);
		}

		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;

	public BST() {
		this.root = null;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public void insert(E x) throws ItemDuplicated {
		this.root = insertRec(x, this.root);
	}

	private Node insertRec(E x, Node current) throws ItemDuplicated {

		Node res = current;

		if (current == null)
			res = new Node(x);
		else {
			int resC = current.data.compareTo(x);
			if (resC == 0)
				throw new ItemDuplicated("El dato " + x + " ya fue insertado antes...");
			if (resC < 0)
				res.right = insertRec(x, current.right);
			else
				res.left = insertRec(x, current.left);
		}
		return res;

	}

	public E search(E x) throws ItemNoFound {
		if (isEmpty())
			System.out.println("BST is Emtpy..");
		else
			return search(x, this.root).data;
		return null;
	}

	public Node search(E x, Node current) {

		Node res = current;

		int resC = current.data.compareTo(x);
		if (resC == 0)
			return res;
		if (resC < 0)
			return search(x, current.right);
		else
			return search(x, current.left);
	}
	
	public void remove(E x) throws ItemNoFound{
		
	}
	
	
	@Override
	public String toString() {
		if (this.root != null)
			return preOrder(this.root);
		else
			return "*";
	}
	
	private String preOrder(Node current) {
		String res = "";
		if(current == null)
			return "";
		res += current.data + ", ";
		res += preOrder(current.left);
		res += preOrder(current.right);
		return res;
	}
	
	
	private String inOrder(Node current) {
		
		String res = "";
		
		if(current == null)
			return "";
		res += inOrder(current.left);
		res += current.data + ", ";
		res += inOrder(current.right);
		return res;// + current.data.toString() + ", ";
	}

	private String postOrden(Node current) {
		String res = "";
		if (current.left != null)
			res += postOrden(current.left);
		if (current.right != null)
			res += postOrden(current.right);

		return res + current.data.toString() + ", ";
	}
	
	public void tiposRecorrido() {
		System.out.println("inOrder : "+inOrder(this.root));
		System.out.println("postOrder : "+postOrden(this.root));
		System.out.println("preOrder : "+preOrder(this.root));
	}

}