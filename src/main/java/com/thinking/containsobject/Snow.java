package com.thinking.containsobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: 李昭
 * @Date: 2020/6/7 10:27
 */
public class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snows = Arrays.asList(new Crusty(), new Slush(), new Powder());
        List<Snow> snowList = Arrays.asList(new Light(), new Heavy());
        List<Snow> list = new ArrayList<>();
        Collections.addAll(list, new Light(), new Heavy());
        List<Snow> l = Arrays.<Snow>asList(new Light(), new Heavy());
    }
}