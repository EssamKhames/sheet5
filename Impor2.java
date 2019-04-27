package eg.edu.alexu.csd.datastructure.stack.cs;
 class Impor2 implements IExpressionEvaluator {
		
	 Impor STA = new Impor();
	 
		public String infixToPostfix(String expression) {
			Object divisor = '/'; Object multi = '*' ; Object minze = '-' ; Object plus = '+' ;
		 int i = 0; char A = '0' ; String Final = "" ; char a = 'a' ; Object Open = '(' ;
		 
		 while(i<expression.length()) {
			 
			 if(expression.charAt(i) != ' ') {
				 
					if(expression.charAt(i)-A <= 9 && expression.charAt(i)-A >= 0) {
						 
						 int k=0;int j = 0; int x = i ; String Before ="" ;double sum = 0 ; 
						 
						 while (expression.charAt(x)-A <= 9 && expression.charAt(x)-A >= 0 ) {
							 Before = Before + (expression.charAt(x)-A); 
							 x++;
							 if(x >= expression.length()) {
								 break ; 
							 }
						 }
						 while (j<Before.length()) {
							 
							 sum = sum + Math.pow(10,j) * (Before.charAt(k)-A);
							 j++;k++;
							 
						 }
						 int sum2 = (int)sum ;
						 Final = Final + sum2 +" ";
						 i=i+j ;
				 	}

					 else if (expression.charAt(i) == '(' ||expression.charAt(i) == ')' ||expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
						 if( expression.charAt(i) == '*') {
							 if(STA.isEmpty() ) {
								 
								 STA.push(expression.charAt(i));
							 }
							 else if (STA.peek() != divisor ) {
								
								 STA.push(expression.charAt(i));
							 }
							 else if (STA.peek() == divisor || STA.peek() == Open) {
								 Final = Final + (char)STA.pop() + " " ;
							 }
						 }
						 else if( expression.charAt(i) == '/') {
							 if(STA.isEmpty() ) {
								 
								 STA.push(expression.charAt(i));
							 }
							 else if (STA.peek() != multi ) {
								
								 STA.push(expression.charAt(i));
							 }
							 else if (STA.peek() == multi || STA.peek() == Open) {
								 Final = Final + (char)STA.pop() + " " ;
							 }
						 }
						 else if( expression.charAt(i) == '+') {
							 if( STA.isEmpty() ) {
								 STA.push(expression.charAt(i));
							 }
							 else if (STA.peek() == multi || STA.peek() == divisor) {
								 Final = Final + (char)STA.pop() + " " ;
								 	if ( STA.peek() == minze || STA.peek() == plus ) {
										Final = Final + (char)STA.pop() + " " ;
										STA.push(expression.charAt(i));
									 }
								 	else {
										STA.push(expression.charAt(i));
								 	}
							 }
							 else if ( STA.peek() == minze ) {
								Final = Final + (char)STA.pop() + " " ;
								STA.push(expression.charAt(i));
							 }
							 else if(STA.peek() == Open) {
									STA.push(expression.charAt(i));
							 }
						 }
						 else if( expression.charAt(i) == '-') {
							 if(STA.isEmpty()) {
								 
								 STA.push(expression.charAt(i));
							 }
							 else if (STA.peek() == multi || STA.peek() == divisor) {
								 Final = Final + (char)STA.pop() + " " ;
								 	if ( STA.peek() == plus || STA.peek() == minze) {
										Final = Final + (char)STA.pop() + " " ;
										STA.push(expression.charAt(i));
									 }
								 	else {
										STA.push(expression.charAt(i));
								 	}
							 }
							 else if ( STA.peek() == plus ) {
								Final = Final + (char)STA.pop() + " " ;
								STA.push(expression.charAt(i));
							 }
							 else if(STA.peek() == Open) {
									STA.push(expression.charAt(i));
							 }
						 }
						 else if (expression.charAt(i) == '(') {
								
							 STA.push(expression.charAt(i));
						 }
						 else if(expression.charAt(i) == ')') {
							 while(STA.peek() != Open) {
								 Final = Final + (char)STA.pop() + " " ;
							 }
							 if(STA.peek() == Open) {
								 STA.pop() ;
								 if(! STA.isEmpty()) {
									 Final = Final + (char)STA.pop() + " " ;
								 }
							 }
							 
						 }
						 i++;
					 }
					 else if(Character.getNumericValue(expression.charAt(i)) >= Character.getNumericValue(a)) {
						 Final = Final + expression.charAt(i) +" ";
						 i++;
					 }
			 	}
			 else {
				 i++ ;
		 }
	 }
		 while (STA.isEmpty() == false) {
			 Final = Final + (char)STA.pop() + " " ;
		 }
	return Final ;
}
	
	 public int evaluate(String expression) {
		 int i = 0 ;char A = '0';
		 
		 while(i<expression.length()) {
			 
			 if(expression.charAt(i) != ' ' ) {
				 if(expression.charAt(i)-A <= 9 && expression.charAt(i)-A >= 0) {
					 
					 int k=0;int j = 0; int x = i ; String Before ="" ;double sum = 0 ; 
					 
					 while (expression.charAt(x)-A <= 9 && expression.charAt(x)-A >= 0 ) {
						 Before = Before + (expression.charAt(x)-A); 
						 x++;
					 }
					 while (j<Before.length()) {
						 
						 sum = sum + Math.pow(10,j) * (Before.charAt(k)-A);
						 j++;k++;
						 
					 }
					 STA.push(sum);
					 i=i+j ;
			 	}
				  else {
					  if(STA.isEmpty() == false) {
						  Object z = STA.pop();
						  Object y = STA.pop();
						  	if(expression.charAt(i) == '*') {
						  		Object M = (double)z*(double)y ;
						  		STA.push(M);
						  	}
						  	else if(expression.charAt(i) == '+') {
						  		Object M = (double)z+(double)y ;
						  		STA.push(M);
						  	}
						  	else if(expression.charAt(i) == '-') {
						  		Object M = (double)y-(double)z ;
						  		STA.push(M);
						  	}
						  	else if(expression.charAt(i) == '/') {
						  		Object M = (double)y/(double)z ;
						  		STA.push(M);
						  	}
					 }
					  else {
							 try {
									throw new Exception ();
								} catch (Exception e) {
									e.printStackTrace();
								}
					  }
				 i++;
				  }
				 
			 }
			 else {
				 i++;
			 }
		 }
		 if(STA.size() == 1) {
			 double de = (double)STA.pop() ; 
			 int de2 = (int)de ; 
			 return de2 ;
		 }
		 else {
			 try {
				throw new Exception ();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return 0 ;
		 }
	 }
}
