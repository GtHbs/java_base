package com.thinking.enumeration.constmethod;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author 李昭
 * @Date 2020/7/15 07/37
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod m : values()) {
            System.out.println(m.getInfo());
        }
    }
}
