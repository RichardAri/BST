
public class Test {
	
	public static void main(String[] args) {
		
		BST<Integer> b = new BST<Integer>();
		
		try {
			
			b.insert(10);
			System.out.println(b);
			b.insert(30);
			System.out.println(b);
			b.insert(4);
			System.out.println(b);
			b.insert(45);
			System.out.println(b);
			b.insert(23);
			System.out.println(b);
			b.insert(18);
			System.out.println(b);
			b.insert(27);
			System.out.println(b);
			b.insert(33);
			System.out.println(b);
			b.insert(9);
			System.out.println(b);
			b.insert(28);
			System.out.println(b);
			
		    System.out.println("Search : "+b.search(28));
			
			b.tiposRecorrido();
			
		} catch (ItemDuplicated e) {
			System.out.println(e.getMessage());
		} catch (ItemNoFound e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
