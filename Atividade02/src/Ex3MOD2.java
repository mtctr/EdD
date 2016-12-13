
// Classe Quicksort a ser completada
class Quicksort {

    static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    static int partition(int[] a, int l, int r) {
        int i = l;
        int j = r;
        int v = a[i];
        
        while (i<j){
        	while (a[i]<v) {
        		i++;
        	}
        	while (a[j]>v) {
        		j--;
        	}
        	if (i < j){ 
        		swap(a,i,j);
        		
        	}
        	if(a[i] == a[j]){
        		j--;
        	}
        	
        }
        
    	return i; 
    }

    static void quickrec(int[] a, int l, int r) {
        
    	int i = partition(a,l,r);
        if(l < i-1){
        	quickrec(a,l,i-1);
        }
    	if(r > i+1){
    		quickrec(a,i+1,r);
    	}
        
    }

    static void quicksort(int[] a) {
        if(a.length != 0){
    	quickrec(a, 0, a.length-1);
        }        
    }

}

