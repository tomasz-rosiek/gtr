package pl.tzr.gumtree.test;

import org.junit.Test;
import pl.tzr.gumtree.LineParser;
import pl.tzr.gumtree.Person;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class LineParserTest {

    @Test
    public void shouldParseValidLine1() {
        assertThat(LineParser.parseLine("Bill McKnight, Male, 16/03/77")).isEqualToComparingFieldByField(
                new Person("Bill McKnight", Person.Sex.MALE, LocalDate.of(1977, Month.MARCH, 16)));
    }

    @Test
    public void shouldParseValidLine2() {
        assertThat(LineParser.parseLine("Paul Robinson, Male, 15/01/85")).isEqualToComparingFieldByField(
                new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(1985, Month.JANUARY, 15)));
    }

    @Test
    public void shouldParseValidLineForSomeoneBornThisYear() {
        assertThat(LineParser.parseLine("Paul Robinson, Male, 15/01/15")).isEqualToComparingFieldByField(
                new Person("Paul Robinson", Person.Sex.MALE, LocalDate.of(2015, Month.JANUARY, 15)));
    }
}