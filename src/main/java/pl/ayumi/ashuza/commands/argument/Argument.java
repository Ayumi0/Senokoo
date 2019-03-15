package pl.ayumi.ashuza.commands.argument;

import java.lang.reflect.Type;
import java.util.Optional;

public interface Argument {

    Class getType();
    String getValue();
}
