
public class FenwickTree {
	int value;
	int leftSize;
	FenwickTree left;
	FenwickTree right;

	public FenwickTree(int value) {
		this.value = value;
	}

	public FenwickTree(int leftSize, FenwickTree left, FenwickTree right) {

		this.leftSize = leftSize;
		this.left = left;
		this.right = right;
		this.value = left.value + right.value;
	}

	public String toString() {
		String str = String.format("[%s, %s", this.value, this.leftSize);
		if(this.left == null && this.right == null){
			str += "]";
		}
		else if(this.left != null && this.right !=null){
			str += String.format(" %s, %s]", this.left.toString(), this.right.toString());
		}
		else if(this.left == null && this.right!= null ){
			str += String.format("%s]", this.right.toString()); 
			
		}
		else if(this.left != null && this.right == null ){
			str += String.format("%s]", this.left.toString()); 
			
		}
		return str;
	}
}
