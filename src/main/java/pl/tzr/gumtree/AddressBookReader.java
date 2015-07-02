package pl.tzr.gumtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AddressBookReader {

    public List<Person> load(String location) {
            try (BufferedReader reader = new BufferedReader(new FileReader(location))){
                return reader.lines().map(LineParser::parseLine).collect(toList());
            } catch (IOException e) {
                throw new AddressBookLoadingFailureException("Loading address book from " + location + " failed.", e);
            }
    }

}
