package reClassLoad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader{
    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            // 首先尝试查找已加载的类
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                try {
                    // 尝试打破双亲委派机制，加载类
                    c = findClass(name);
                } catch (ClassNotFoundException e) {
                    // 如果没有在自定义类加载器中找到类，则委派给父加载器
                    c = super.loadClass(name, resolve);
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = loadClassData(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot find class " + name, e);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        String path = className.replace('.', '/');
        String classFilePath = classPath + path + ".class";
        File file = new File(classFilePath);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        }
    }
}
