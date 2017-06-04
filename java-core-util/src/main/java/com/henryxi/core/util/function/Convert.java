package com.henryxi.core.util.function;

import java.util.function.Consumer;
import java.util.function.Function;

public class Convert {

    public static WrapperUser convert(User user) {
        WrapperUser wrapperUser = new WrapperUser();
        wrapperUser.setId(user.getId());
        wrapperUser.setName(user.getName());
        return wrapperUser;
    }

    public static <S, R> void convert(Consumer<R> tf, S s, Function<S, R> sf) {
        R value = sf.apply(s);
        tf.accept(value);
    }
}
