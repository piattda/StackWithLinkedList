import static org.junit.Assert.assertEquals;

import org.junit.Test;


import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 * 
 * @author Put your name here
 * 
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     * 
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     * 
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     * 
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     * 
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     * 
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     * 
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    // TODO - push test cases for constructor, push, pop, and length

    @Test
    public void testConstructor(){
        Stack<String> StackTest = this.createFromArgsTest();
        Stack<String> StackRef = this.createFromArgsRef();
        assertEquals(StackRef, StackTest);
    }
    
    @Test
    public void testConstructor2(){
        Stack<String> StackTest = this.createFromArgsTest("1","2");
        Stack<String> StackRef = this.createFromArgsRef("1","2");
        assertEquals(StackRef, StackTest);
    }
    
  //push 
    @Test
    public void testpush1(){
        Stack<String> StackTest = this.createFromArgsTest("1", "2");
        Stack<String> StackRef = this.createFromArgsRef("3","1","2");
        
        StackTest.push("3");
        assertEquals(StackRef, StackTest);
    }
    
    //pushing to empty Stack
    @Test
    public void testpushEmpty(){
        Stack<String> StackTest = this.createFromArgsTest();
        Stack<String> StackRef = this.createFromArgsRef("1");
        
        StackTest.push("1");
        
        assertEquals(StackRef, StackTest);
        
    }
    
    @Test
    public void testpushMultiple(){
        Stack<String> StackTest = this.createFromArgsTest();
        Stack<String> StackRef = this.createFromArgsRef("3","2","1");
        
        StackTest.push("1");
        StackTest.push("2");
        StackTest.push("3");
        
        assertEquals(StackRef, StackTest);
    }

    //pop all
    
    @Test
    public void testpop(){
        
        Stack<String> StackTest = this.createFromArgsTest("1","2", "3");
        Stack<String> StackRef = this.createFromArgsRef();
        
        StackTest.pop();
        StackTest.pop();
        StackTest.pop();
        
        assertEquals(StackTest,StackRef);
        
        
        
    }
    
    //pop some
    
    @Test
    public void testpop2(){
        Stack<String> StackTest = this.createFromArgsTest("1","2", "3");
        Stack<String> StackRef = this.createFromArgsRef("3");
        
        StackTest.pop();
        StackTest.pop();
        
        assertEquals(StackTest,StackRef);
    }
    
    
    
    
        
    @Test
    public void testSize(){
        Stack<String> StackTest = this.createFromArgsTest();

        int size = 0;
        assertEquals(size, StackTest.length());
    }
    
    @Test
    public void testSizeWithElements(){
        Stack<String> StackTest = this.createFromArgsTest("1","2","3");
        
        int size = 3;
        
        assertEquals(size, StackTest.length());
    }

    
}
