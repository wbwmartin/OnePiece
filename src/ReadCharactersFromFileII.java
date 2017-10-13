//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//        The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//        By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//        Notice
//
//        The read function may be called multiple times.

public abstract class ReadCharactersFromFileII {

    char[] buf4 = new char[4];
    int i4 = 0, n4 = 0;

    public int read(char[] buf, int n) {
        // Write your code here
        int i = 0;
        while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4))))
            buf[i++] = buf4[i4++];
        return i;
    }

    public abstract int read4(char[] buf);
}
