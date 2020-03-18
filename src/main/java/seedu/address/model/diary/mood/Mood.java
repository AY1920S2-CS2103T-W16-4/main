package seedu.address.model.diary.mood;

public abstract class Mood {
    private final String mood;

    protected Mood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "[" + mood + "]";
    }
}
