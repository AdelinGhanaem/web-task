package com.cayetano.core;

import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public interface Adapter<T, E> {


    List<T> to(List<E> e);


    E from(T t);
}
