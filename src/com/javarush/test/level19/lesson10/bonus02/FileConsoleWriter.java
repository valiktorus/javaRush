package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/
import java.io.*;
public class FileConsoleWriter extends FileWriter{
    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }
    @Override
    public void write(String str, int off, int len) throws IOException
    {
        char cbuf[];
        cbuf = new char[len];
        str.getChars(off, (off + len), cbuf, 0);
        write(cbuf, 0, len);
    }
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        super.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off+len));
    }
    @Override
    public void write(int c) throws IOException
    {
        char[] buff = new char[1];
        buff[0] = (char) c;
        write(buff,0,1);
    }
}