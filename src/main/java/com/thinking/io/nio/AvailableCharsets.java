package com.thinking.io.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharsets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Iterator<String> it = charsets.keySet().iterator();
        while (it.hasNext()) {
            String csName = it.next();
            System.out.println(csName);
            Iterator<String> aliases = charsets.get(csName).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(" : ");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(",");
                }
            }
        }
    }
}
