package pl.ayumi.senokoo.commands.argument;

public class ArgumentImpl implements Argument {
    private Class type;
    private String value;

    public ArgumentImpl(Class type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public Class getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }
}
