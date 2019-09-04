package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Scanner;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumping;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram()
    {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dumping = true;
        while(isRunning)
        {
            ByteCode code = program.getCode(pc);
            code.executeProgram(this);
            isDumping(code);
            pc++;
        }
    }

    public void setDumping(boolean bool)
    {
        this.dumping = bool;
    }

    public void isDumping(ByteCode code)
    {
        if(dumping)
        {
            System.out.print(code.toString());
            runStack.dump();
        }
    }

    public void newframe(int n)
    {
        runStack.newFrameAt(n);
    }

    public int peek()
    {
        return runStack.peek();
    }

    public int pop()
    {
        return runStack.pop();
    }

    public void popFrame()
    {
        runStack.popFrame();
    }

    public void push(int n)
    {
        runStack.push(n);
    }

    public void setPC(int pc)
    {
        this.pc = pc;
    }

    public int returnPop()
    {
        return (int)returnAddrs.pop();
    }

    public void save()
    {
        returnAddrs.push(pc);
    }

    public void running(boolean bool)
    {
        isRunning = bool;
    }

    public void storeCode(int offset) {
        runStack.store(offset);
    }

    public void loadCode(int offset)
    {
        runStack.load(offset);
    }

    public void popStack(int stack)
    {
        int n = stack;
        if(n < runStack.stackSize())
        {
            while(n > -1)
            {
                runStack.pop();
                n--;
            }
        }
    }

    public int read()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        return scan.nextInt();
    }
}
