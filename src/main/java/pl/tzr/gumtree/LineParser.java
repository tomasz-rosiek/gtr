package pl.tzr.gumtree;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Map;

public class LineParser {

    public static Map<String, Person.Sex> SEX_MAP = new ImmutableMap.Builder<String, Person.Sex>()
                    .put("Male", Person.Sex.MALE)
                    .put("Female", Person.Sex.FEMALE).build();

    public static Person parseLine(String line) {
        String[] chunks = line.split(",");
        if (chunks.length != 3) throw new AddressBookLoadingFailureException("Failure parsing line " + line + ". Invalid column number.");

        String name = chunks[0].trim();
        Person.Sex sex = SEX_MAP.get(chunks[1].trim());
        if (sex == null) throw new AddressBookLoadingFailureException("Invalid sex specified " + chunks[1].trim());

        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().
                appendPattern("dd/MM/").
                appendValueReduced(ChronoField.YEAR, 2, 2, Year.now().getValue() - 99).
                toFormatter();

        LocalDate birthDate = LocalDate.parse(chunks[2].trim(), dateTimeFormatter);

        return new Person(name, sex, birthDate);
    }

}
