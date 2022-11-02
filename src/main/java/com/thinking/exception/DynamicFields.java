package com.thinking.exception;

/**
 * @Author 李昭
 * @Date 2020/6/14 18/03
 */
public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object[] objects : fields) {
            builder.append(objects[0]);
            builder.append(": ");
            builder.append(objects[1]);
            builder.append("\n");
        }
        return builder.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNumber;
    }

    private int makeField(String id) {
        //1,如果数组中有空位置,则将key放入,并返回下标位置
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        //2, 所有的空间都被占满,需要重新创建数组,并将原始的数据存入到新数组中
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        //3, 初始化新开辟的空间
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[]{null, null};
        }
        //4, 将新数组赋值给旧数组
        fields = tmp;
        //5, 递归调用,重新赋值
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        //1, 先判断值是否为空,如果为空直接抛出异常
        if (value == null) {
            DynamicFieldsException exception = new DynamicFieldsException();
            exception.initCause(new NullPointerException());
            throw exception;
        }
        //2, 获取值看是否存在,如果不存在就设置值
        int field = hasField(id);
        if (field == -1) {
            field = makeField(id);
        }
        Object result = null;
        //3, 如果值存在(可能是刚设置的),就将值取出并返回
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        //4, 设置值
        fields[field][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields fields = new DynamicFields(3);
        System.out.println(fields);
        try {
            fields.setField("d", "A value for d");
            fields.setField("number", 47);
            fields.setField("number2", 48);
            System.out.println(fields);
            fields.setField("number", "A new Value for d");
            fields.setField("number", 11);
            System.out.println("fields:" + fields);
            System.out.println("fields.getField(): " + fields.getField("id"));
        } catch (DynamicFieldsException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

class DynamicFieldsException extends Exception {
}


class TestException {
    static void f() {
        try {
            g();
        } catch (DynamicFieldsException e) {
            throw new RuntimeException();
        }
    }

    static void g() throws DynamicFieldsException {
        throw new DynamicFieldsException();
    }

    public static void main(String[] args) {
        f();
    }
}
