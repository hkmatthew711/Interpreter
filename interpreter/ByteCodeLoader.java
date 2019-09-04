
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes()
    {
        String nextLine, className, token;
        ByteCode byteCode;
        ArrayList<String> arrayList = new ArrayList<>();

        program = new Program();

        try
        {
            nextLine= byteSource.readLine();

            while(nextLine != null)
            {
                StringTokenizer str = new StringTokenizer(nextLine);
                token = str.nextToken();
                className = CodeTable.getClassName(token);
                Class interpreter = Class.forName("interpreter.bytecode." + className);
                byteCode = (ByteCode) interpreter.getDeclaredConstructor().newInstance();

                while(str.hasMoreTokens())
                {
                    arrayList.add(str.nextToken());
                }
                byteCode.init(arrayList);
                program.addByteCode(byteCode);
                arrayList.clear();
                nextLine = byteSource.readLine();
            }

        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.toString());
        }
        catch(InstantiationException e)
        {
            System.out.println(e.toString());
        }
        catch(IllegalAccessException e)
        {
            System.out.println(e.toString());
        }
        catch (NoSuchMethodException e)
        {
            System.out.println(e.toString());
        }
        catch (InvocationTargetException e)
        {
            System.out.println(e.toString());
        }
        program.resolveAddrs(program);
        return program;
    }
}
