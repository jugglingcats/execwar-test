package com.acme;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        JarJarURLConnection.register();

        List<URL> urls = new ArrayList<>();
        urls.add(new URL("jar:jarjar:file:webapp.war^/lib.jar!/"));

        System.out.println("creating classloader");
        URLClassLoader classLoader = new URLClassLoader(urls.toArray(new URL[0]));

        System.out.println("getting resource as stream");
        InputStream stream = classLoader.getResourceAsStream("test.txt");
        if (stream == null) {
            throw new IllegalStateException("Didn't resolve resource");
        }
    }
}
