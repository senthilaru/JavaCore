class StackUsingArray{
  String[] stack;
  int currentIndex = 0;
  public StackUsingArray(int size){
    stack = new String[size];
    }
    
    public void push(String msg){
      if(currentIndex <= stack.length ){
        stack[currentIndex] = msg;
      }
      currentIndex++;
    }
    
    public void pop(){
      String msg = stack[currentIndex];
      stack[currentIndex] = null; // This leads to Memory Leak (Loitering) if not nullify.
      currentIndex--;
      return msg;
    }
    }
