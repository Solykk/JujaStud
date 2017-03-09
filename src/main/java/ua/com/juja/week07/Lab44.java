package ua.com.juja.week07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * В системе есть два класса сущностей class Point class Person.
 * Для работы с этими сущностями было создано два интерфейса EntityOutput EntityInput,
 * которые декларируют методы записи и считывания сущностей.
 * Интерфейс EntityOutput уже реалиован в классе EntityOutputWriter.
 * По образу и подобию нужно реализовать интерфейс EntityInput в классе EntityInputReader.
 * Для класса EntityInputReader необходимо создать конструктор со следующей сигнатурой:
 * public EntityInputReader(Reader in)
 */

public class Lab44 implements EntityOutput{
    private final Writer out;

    public Lab44(Writer out) {
        this.out = out;
    }

    public void writePerson(Person person) throws IOException {
        int age = person.getAge();
        String name = person.getName();
        out.write("<person>n");
        out.write("    <age>" + age + "</age>n");
        out.write("    <name>" + name + "</name>n");
        out.write("</person>n");
        out.flush();
    }

    @Override
    public void writePoint(Point point) throws IOException {
        out.write("<point x=" + point.getX() + " y=" + point.getY() + "></point>n");
        out.flush();
    }
}

class EntityInputReader implements EntityInput {
    private Reader in;

    public EntityInputReader(Reader in){
        this.in = in;
    }

    @Override
    public Person readPerson() throws IOException {
        char[] chars = new char[100];
        in.read(chars);
        String string = new String(chars);
        Pattern p = Pattern.compile("<age>(\\S+)</age>");
        Matcher m = p.matcher(string);
        String age = "";
        if (m.find()) {
            age = m.group(1);
        }
        Pattern pp = Pattern.compile("<name>(\\S+)</name>");
        Matcher mm = pp.matcher(string);
        String name = "";
        if (mm.find()) {
            name = mm.group(1);
        }
        return new Person(name, new Integer(age));
    }

    @Override
    public Point readPoint() throws IOException {
        char[] chars = new char[100];
        in.read(chars);
        String string = new String(chars);
        Pattern p = Pattern.compile("<point x=(\\S+)");
        Matcher m = p.matcher(string);
        String x = "";
        if (m.find()) {
            x = m.group(1);
        }
        Pattern pp = Pattern.compile("<point x=" + x + " y=(\\S+)></point>");
        Matcher mm = pp.matcher(string);
        String y = "";
        if (mm.find()) {
            y = mm.group(1);
        }

        return new Point(new Integer(x), new Integer(y));
    }
}
