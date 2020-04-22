package com.example.springkafkastudy.serde.serializer;

import java.io.Closeable;

public interface Serializer<T> extends Closeable {

    byte[] serialize(T obj);
    void close();

}
