package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        System.out.print("[");

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(!runTimeStack.isEmpty())
        {
            for (int i = 0; i < framePointer.size(); i++)
            {
                if (framePointer.get(i) > 0)
                {
                    arrayList.add(framePointer.get(i));
                }
            }
        }

        boolean comma = true;
        int stackSize = runTimeStack.size();
        for(int i = 0; i < stackSize; i++)
        {
            int j = 0;
            if(!arrayList.isEmpty() && j < arrayList.size())
            {
                if(arrayList.get(j) == i)
                {
                    System.out.print("] [");
                }
                else if(arrayList.get(j) == i+1)
                {
                    comma = false;
                }
            }
            System.out.print(runTimeStack.get(i));

            if(!runTimeStack.isEmpty() && stackSize != i+1)
            {
                if(!comma)
                {
                    comma = true;
                } else {
                    System.out.print(",");
                }
            }
        }
        System.out.println("]");

    }

    public int peek()
    {
        return (int) runTimeStack.get(runTimeStack.size()-1);
    }

    public int pop()
    {
        return (int) runTimeStack.remove(runTimeStack.size()-1);
    }

    public void newFrameAt(int offset)
    {
        framePointer.push(runTimeStack.size()-offset);
    }

    public int store(int offset)
    {
        int storeValue = (int) runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(offset + framePointer.peek(), storeValue);
        return storeValue;
    }

    public int load(int offset)
    {
        int loadValue = (int) runTimeStack.get(offset+ framePointer.peek());
        runTimeStack.add(loadValue);
        return loadValue;
    }

    public void popFrame()
    {
        int value = (int) runTimeStack.remove(runTimeStack.size()-1);
        while(runTimeStack.size()> framePointer.peek())
        {
            runTimeStack.remove(runTimeStack.size()-1);
        }
        framePointer.pop();
        runTimeStack.add(value);
    }

    public int stackSize()
    {
        return runTimeStack.size();
    }

    public Integer push(Integer val)
    {
        runTimeStack.add(val);
        return val;
    }
}
