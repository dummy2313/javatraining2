import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @author G20190343010623 xuyue
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class hello = new HelloClassLoader().findClass("Hello");
        Method method = hello.getDeclaredMethod("hello", null);
        Object obj = hello.newInstance();
        method.invoke(obj);
    }

    @Override
    protected Class<?> findClass(String name) {
        String helloBase64 = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABYMABcAGAEAE0hlbGxvLCBjbGFzc0xvYWRlciEHABkMABoAGwEABUhlbGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAEAAQALAAgAAQAJAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABAAIAAUAAQAMAAAAAgAN";
        byte[] bytes = decode(helloBase64);
        return defineClass(name, bytes, 0, bytes.length);

    }

    public byte[] decode(String helloBase64) {
        return Base64.getDecoder().decode(helloBase64);
    }

}
