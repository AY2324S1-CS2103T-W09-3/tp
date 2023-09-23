package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents remarks of a Person object
 */
public class Remark {

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param remark the remark of a Person object
     */
    public Remark(String remark) {
        requireNonNull(remark);
        this.value = remark;
    }
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark)) {
            return false;
        }

        Remark otherAddress = (Remark) other;
        return this.value.equals(otherAddress.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
