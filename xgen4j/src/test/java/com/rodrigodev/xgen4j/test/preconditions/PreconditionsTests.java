package com.rodrigodev.xgen4j.test.preconditions;

import com.rodrigodev.xgen4j.ExceptionsGenerator;
import com.rodrigodev.xgen4j.test.TestSpecification;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 24/06/15.
 */
public class PreconditionsTests extends TestSpecification {

    @Test
    public void sourceDirectoryMustExist() {
        assertThatThrownBy(
                () -> {
                    // @formatter:off
                    new ExceptionsGenerator(SRC_DIR_PATH + "/java/com/rodrigodev/xgen/test/preconditions/sourceDirectoryMustExist");
                    // @formatter:on
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Source directory doesn't exist.");
    }
}
