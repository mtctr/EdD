import java.util.LinkedList;

// A classe Mergesort a ser completada
class Mergesort {

    static void split(LinkedList<Integer> l, LinkedList<Integer> l1, LinkedList<Integer> l2) {
    	for(int i = 0; i<(l.size()/2); i++) {
    		l1.add(l.get(i));
    	}
    	
    	for(int i = (l.size()/2); i< l.size(); i++) {
    		l2.add(l.get(i));
    	}
        
    }

    static LinkedList<Integer> merge(LinkedList<Integer> l1,
                                     LinkedList<Integer> l2) {
    	
    	
        LinkedList<Integer> listaOrdenada = new LinkedList<Integer>();
        
        int cont1 = 0; 
        int cont2 = 0;
        
        while(cont1 < l1.size() && cont2 < l2.size()) {
        	if (l1.get(cont1) < l2.get(cont2)) {
        		
        		listaOrdenada.add(l1.get(cont1));
        		cont1++;
        	} else {
        		listaOrdenada.add(l2.get(cont2));
        		cont2++;
        	}        	
        }
        
        if (cont1 == l1.size()) {
        	for(int i=cont2; cont2<l2.size(); cont2++) {
        		listaOrdenada.add(l2.get(cont2));
        	}
        } else {
        	for(int i=cont1; cont1<l1.size(); cont1++) {
        		listaOrdenada.add(l1.get(cont1));
        	}
        }
        
     
        return listaOrdenada;
    }

    static LinkedList<Integer> mergesort(LinkedList<Integer> l) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        
        
    
        if(l.size() > 1){
            split(l,l1,l2);
        	l1 = mergesort(l1);
        	l2 = mergesort(l2);
        	return merge(l1,l2);
        }
        
        return l;
        
    }
}


