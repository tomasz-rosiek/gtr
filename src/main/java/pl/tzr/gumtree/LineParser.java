package pl.tzr.gumtree;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class LineParser {

    public static Person parseLine(String line) {
        String[] chunks = line.split(",");
        if (chunks.length != 3) throw new AddressBookLoadingFailureException("Failure parsing line " + line + ". Invalid column number.");

        String name = chunks[0].trim();
        Person.Sex sex;
        switch (chunks[1].trim()) {
            case "Male":
                sex = Person.Sex.MALE;
                break;
            case "Female":
                sex = Person.Sex.FEMALE;
                break;
            default:
                throw new AddressBookLoadingFailureException("Invalid sex specified " + chunks[1].trim());
        }
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().
                appendPattern("dd/MM/").
                appendValueReduced(ChronoField.YEAR, 2, 2, Year.now().getValue() - 99).
                toFormatter();

        LocalDate birthDate = LocalDate.parse(chunks[2].trim(), dateTimeFormatter);

        return new Person(name, sex, birthDate);
    }

}
