package org.training.training_main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int h;
        System.out.println((h = 12));
        int i;
        System.out.println(i = 23);
        System.out.println(((h = 12) ^ (h >>> 16)));
    }
}
