package com.thinking.enumeration.interfaceenum;

import com.thinking.enumeration.randomaccess.Enums;

/**
 * @Author 李昭
 * @Date 2020/7/14 07/38
 */
public enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    private Security[] values;

    SecurityCategory(Class<? extends Security> c) {
        values = c.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + " : " + category.randomSelection());
        }
    }


}
