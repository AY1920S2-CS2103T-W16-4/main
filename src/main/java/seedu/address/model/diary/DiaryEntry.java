package seedu.address.model.diary;

import java.util.Optional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import seedu.address.model.diary.mood.Mood;
import seedu.address.model.diary.weather.Weather;

public class DiaryEntry {
    private LocalDate date;
    private Optional<Weather> weather;
    private Optional<Mood> mood;
    private String entryContent;

    private DiaryEntry(LocalDate date, Weather weather, Mood mood, String entryContent) {
        this.date = date;
        this.weather = Optional.ofNullable(weather);
        this.mood = Optional.ofNullable(mood);
        this.entryContent = entryContent;
    }

    public DiaryEntry(String entryContent) {
        this(LocalDate.now(), null, null, entryContent);
    }

    public String getHeading() {
        String heading = "";
        heading += " DATE: " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " | ";
        heading += "WEATHER: " + (weather.isPresent() ? weather.get().toString() : "N.A.") + " | ";
        heading += "MOOD: " + (mood.isPresent() ? mood.get().toString() : "N.A.") + " | ";
        return heading + "\n";
    }

    @Override
    public String toString() {
        String dairyDisplay = "";
        dairyDisplay += getHeading();
        dairyDisplay += "_".repeat(50) + "\n";
        dairyDisplay += entryContent + "\n";
        return dairyDisplay;
    }
}
