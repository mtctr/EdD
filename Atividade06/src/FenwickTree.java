
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
	
	//passo5
	public void increment(int i, int delta){
		if(this.left == null){
			this.value += delta;
		}
		else{
			this.value += delta;
			if(i < this.leftSize){
				this.left.increment(i, delta);
			}
			else{
				this.right.increment(i - this.leftSize, delta);
			}
		}
	}
	
	//passo6
	public int prefixSum(int upTo){
		if(upTo == 0){
			return 0;
		}
		else if(this.left == null){
			return value;
		}
		else{
			if(upTo <= this.leftSize){
				return this.left.prefixSum(upTo);
			}
			else{
				return this.left.value + this.right.prefixSum(upTo - this.leftSize);
			}
		}				
	}
	
	//passo 7	
	public int between(int lo, int hi){
		return prefixSum(hi)-prefixSum(lo);
	}
	
	//passo 2
	public String toString() {
		String str = String.format("[%s, %s", this.value, this.leftSize);
		if(this.left == null){
			str += "]";
		}
		else {
			str += String.format(" %s, %s]", this.left.toString(), this.right.toString());
		}
		
		return str;
	}
		
}
