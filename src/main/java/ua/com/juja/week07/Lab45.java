package ua.com.juja.week07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Необходимо реализовать метод со следующей сигнатурой
 * public static void filter(InputStream src, OutputStream dst, int bufferSize, byte filterCriteria) throws IOException
 * На вход подается поток байтов.
 * Суть задачи - переписать в выходной поток (stream) все байты за исключением байтов, который равняются filterCriteria.
 * Для оптимизации при операциях с потоками данных используется буффер, размер которого задается входящим параметром bufferSize.
 * Запись в исходящий поток нужно делать пакетами байт.
 * Например:
 * Входящий поток байтов
 * 1 0 0 2 34 5 6 7 78 8 9 0 2 3 5 6 7 7
 * filterCriteria = 0
 * bufferSize = 4
 * Исходящий поток имеет вид
 * 1 2 34 5 6 7 78 8 9 2 3 5 6 7 7.
 * Список вызовов функции read/write
 *
 * read(b[4])  - считываем 4 байта в буффер и начинаем проверку
 * write(b[4],0,1) - записываем 1-й байт в исходящий поток
 * write(b[4],3,1) - исключив 2 следующих байта записываем 4-й байт в исходящий поток
 * read(b[4]) -  считываем 4 байта в буффер и начинаем проверку
 * write(b[4],0,4) - все 4 байта записываем в исходящий поток
 * read(b[4]) - считываем 4 байта в буффер и начинаем проверку
 * write(b[4],0,3)- записываем первые 3 байта в исходящий поток и т.д.
 * read(b[4])
 * write(b[4],0,4)
 * read(b[4])
 * write(b[4],0,2)
 * read(b[4])
 */

public class Lab45 {
    public static void filter(InputStream src, OutputStream dst, int bufferSize, byte filterCriteria) throws IOException {
        byte[] data = new byte[bufferSize];
        int bytesRead = src.read(data);

        while(bytesRead != -1) {
            int from = 0;
            int count = 0;
            int pre = 0;
            for (int i = 0; i < data.length; i++) {
                if(data[i] != filterCriteria){
                    count++;
                    from = pre;
                    pre = 0;
                    if (i == data.length - 1 && count == 4){
                        dst.write(data, from , count);
                    }
                    else  if(i == data.length - 1){
                        dst.write(data, from + 1, count - 1);
                    }
                } else {
                    if(pre == 0){
                        dst.write(data, from, count);
                    }
                    pre++;
                }
            }
            data = new byte[bufferSize];
            bytesRead = src.read(data);
        }
    }
}
