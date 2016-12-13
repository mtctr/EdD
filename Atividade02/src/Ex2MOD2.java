
// A classe DutchFlag a ser completada
class DutchFlag {

    static void swap(int[] a, int i, int j) {
        int aux = a[j];
        a[j] = a[i];
        a[i] = aux;
    }

    static void dutch_flag(int[] a) {
        int i = 0, b = 0, r = (a.length-1);            
      
        while (i <= r){
        	if(a[i] == 0){
        		swap(a,i++,b++);
        	}
        	else if(a[i]== 2){
        		swap (a,i,r--);
        	}
        	else
        		i++;   	
        }
    }

}



