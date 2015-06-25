package com.rodrigodev.xgen.preconditions;

import com.rodrigodev.xgen.ExceptionsGenerator;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 24/06/15.
 */
public class PreconditionsTests {

    @Test
    public void sourceDirectoryMustExist() {
        assertThatThrownBy(
                () -> {
                    // @formatter:off
                    new ExceptionsGenerator("src/test-gen/java/com/rodrigodev/xgen/test/preconditions/sourceDirectoryMustExist");
                    // @formatter:on
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Source directory doesn't exist.");
    }
}
