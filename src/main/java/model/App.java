package model;
import lombok.*;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Hello world!
 *
 */
@Getter
@Setter
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    };
    
    @Test
    public void test(){
        System.out.println("lalalalalal");
    }
}
