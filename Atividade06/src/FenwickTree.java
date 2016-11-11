
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
	
	//passo 3
	public static FenwickTree allZeros(int n){
		if (n==0) return null;
		if (n==1) return new FenwickTree(0);
		int m = n/2;
		return new FenwickTree(n-m, allZeros(n-m), allZeros(m));
		}
	
	//passo 4
	public int size(){
		int size = 1;
		if(this.left == null && this.right == null){
			return size;
		}
		else {
			return this.leftSize + this.right.size();
		}
	}
	
	public void increment(int i, int delta){
		if(this.left == null){
			this.value += delta;
		}else{
			this.value += delta;
			if(i < this.leftSize){
				this.left.increment(i, delta);
			}else{
				this.right.increment(i - this.leftSize, delta);
			}
		}
	}
	
//	public int prefixSum(int upTo){
//		int soma = 0;
//		
//		if(this.left == null){
//			soma += value;
//		}else{
//			if(upTo < this.leftSize){
//				soma += this.left.prefixSum(this.leftSize - upTo);
//			}else{
//				soma += this.left.prefixSum(this.leftSize - upTo);
//				soma += this.right.prefixSum(this.leftSize - upTo);
//			}
//		}
//		
//		return soma;
//	}
	
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
