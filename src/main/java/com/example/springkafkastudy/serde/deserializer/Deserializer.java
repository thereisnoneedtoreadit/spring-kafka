package com.example.springkafkastudy.serde.deserializer;

import java.io.Closeable;

public interface Deserializer<T> extends Closeable {

    T deserialize(byte[] bytes);
    void close();

}
