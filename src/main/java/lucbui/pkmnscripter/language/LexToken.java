package lucbui.pkmnscripter.language;

/**
 * An immutable object which represents a token recieved from the parser.
 */
public class LexToken {
    private Object value;
    private int line;
    private int column;
    private LexType type;

    public LexToken(Object value, int line, int column, LexType type) {
        this.value = value;
        this.line = line;
        this.column = column;
        this.type = type;
    }

    public LexToken(int line, int column, LexType type) {
        this.line = line;
        this.column = column;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public LexType getType() {
        return type;
    }
}
