package com.alious.okio.lib;

import java.io.File;
import java.io.IOException;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class MyClass {

    public static final String FILE_NAME = "temp_file";
    public static final String CONTENT = "Okio vs java io library";

    public static void main(String[] args) throws IOException {
//        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
//        fileOutputStream.write(CONTENT.getBytes());
//        fileOutputStream.close();

        File file = new File(FILE_NAME);

        Sink sink = Okio.sink(file);
        BufferedSink bufferedSink = Okio.buffer(sink);
//        bufferedSink.writeString(CONTENT, Charset.defaultCharset());
        bufferedSink.writeInt(1999);
        bufferedSink.flush();
        bufferedSink.close();

        Source source = Okio.source(file);
        BufferedSource bufferedSource = Okio.buffer(source);
//        String readString = bufferedSource.readString(Charset.defaultCharset());
        System.out.println(bufferedSource.readInt() + "");
        bufferedSource.close();

    }

}
