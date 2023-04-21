package praktikum.helpers;

import junitparams.mappers.DataMapper;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XxxToNullMapper implements DataMapper {
    @Override
    public Object[] map(Reader reader) {
        return new BufferedReader(reader).lines()
                .map(line -> line.split(","))
                .map(columns ->
                        Stream.of(columns)
                                .map(column -> column.equals("xxx") ? null : column)
                                .collect(Collectors.toList()).toArray()
                ).toArray();
    }
}
