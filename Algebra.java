// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int abs(int x) {
int count = 0;
if (x<0){
	while(x<0){
		x++;
		count++;
	}
}
else{
	count=x;
}
		return count;
	}
	public static int plus(int x1, int x2) {
	if(x2>=0){	
		for(int i=0; i< x2; i++) {
		x1++;	
		}
	}
	else{
		int i = x2;
		int count=0;
		while(i<0){
			i++;
			count++;
		}
		x1= minus(x1,count);
		}
		return x1;
	}

	
	

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2>=0){
		for(int i =0; i< x2; i++) {
			x1--;
		}
		}
		else{
			int y = x2;
			int count =0;
			while(y<0){
				y++;
				count++;
			}
			x1=plus(x1,count); 
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int g = 0;
		int r =0;
		int x = x1;
		int y = x2;
		if(x1==0||x2==0){
			return 0;
		}
		else if(x1<0){
			int count = 0;
			for(int i=x1; i<0; i++){
				count++;
			}
		x = count;	
		}
		if(x2<0){
			int count = 0;
			for(int i=x2; i<0;i++){
				count++;
			}
		y = count;
		}
		for(int i=0; i< y; i++){
			for (int j = 0; j<x; j++){
				r++;
			}
			g = r;			
	}
	if(x1>0 && x2<0||x1<0 && x2>0) {
		g = minus(0,g);
	}

	return g;
	}
	
	
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int k =1;
		int storeX= x;
		if(x<0){
			storeX= minus(0,x);
		}
		for (int w= 0; w<n; w++){
			int g=0;
			for(int i=0; i<storeX;i++){
				for(int j=0; j<k;j++){
					g++;
				}
			}
		k = g;
		}
		if(x<0){ // after mod op change this
			k = minus(0,k);
		}
		return k;
	}
		
	
	


	
	

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int num = 0;
		int counter = 0;
		int k = x1;
		int g = x2;
		if(x2==0){
			return -1;
		}
		if(x1<0){
			k = minus(0,k);
		}
		if(x2<0){
			g = minus(0,g);
		}
		while( k>num){
			num = plus(num,g);
			counter++;
		}
		if(num>k){
			counter = counter -1;
		}
		if((x1<0 && x2>0)|| (x1>0 && x2<0)){
			counter = minus (0,counter);
		}
		return counter ;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int num= 0;
		int counter =0;
		while(x1>num){
			num = plus(num,x2);
			counter++;
		}
		if(num>x1){
			counter = counter-1;
		}
		int result = x1-(times(counter,x2));
		return result;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for(int i=0; x>=i; i++){
			if (pow(i,2) ==x){
				return i;
			}
			else if (pow(i,2)>x){
				return (i-1);
			}
			
			}
			
		
		return 0;
	}	  	  
}