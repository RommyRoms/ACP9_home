package tasks;

/**
 * Created by mayun8 on 09.12.2015.
 */
public class Tax{

private int x;

    public Tax(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tax tax = (Tax) o;

        return x == tax.x;

    }

    @Override
    public int hashCode() {
        return x;
    }
}
