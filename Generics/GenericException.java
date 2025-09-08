// You cannot create instances of generic types as exceptions.
// The Java runtime needs to be able to construct exceptions based on the exact type.
// But due to type erasure, the JVM loses the specific type information at runtime.

package Generics;

public class GenericException {
    // Generic Methods with Exceptions
    public static <T extends Exception> void throwGenericException(Class<T> exceptionClass) throws T {
        try {
            throw exceptionClass.getDeclaredConstructor(String.class).newInstance("Generic Exception");
        } catch (Exception e) {
            throw (T) e;  // Casting to generic type
        }
    }

    public static void main(String[] args) {
        try {
            throwGenericException(IllegalArgumentException.class);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Output: Generic Exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
