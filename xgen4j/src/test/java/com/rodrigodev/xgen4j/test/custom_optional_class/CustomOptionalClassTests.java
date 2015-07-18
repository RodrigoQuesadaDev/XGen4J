/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Rodrigo Quesada <rodrigoquesada.dev@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rodrigodev.xgen4j.test.custom_optional_class;

import com.rodrigodev.xgen4j.GenerationOptions;
import com.rodrigodev.xgen4j.model.support.optional.OptionalClassType;
import com.rodrigodev.xgen4j.test.TestSpecification;
import lombok.Value;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.rodrigodev.xgen4j.model.error.configuration.ErrorConfiguration.rootError;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Rodrigo Quesada on 13/07/15.
 */
public class CustomOptionalClassTests extends TestSpecification {

    public CustomOptionalClassTests() {
        generateOptionalClassForTests();
    }

    private void generateOptionalClassForTests() {
        // @formatter:off
        generator().generate(rootError("Root").basePackage("com.rodrigodev.xgen4j.test.custom_optional_class").build(),
                      GenerationOptions.builder().optionalClassType(OptionalClassType.CUSTOM).build());
        // @formatter:on
    }

    @Test
    public void empty_returnsAnEmptyOptionalInstance() {

        Optional actualOptional = Optional.empty();

        assertThat(actualOptional.isPresent()).isFalse();
        assertThatThrownBy(actualOptional::get)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No value present");
    }

    @Test
    public void of_anObjectIsPassed_returnsAnOptionalWithTheSpecifiedPresentNonNullValue() {
        TestObject expectedValue = new TestObject("abc", 123);

        Optional<TestObject> actualOptional = Optional.of(expectedValue);

        assertThat(actualOptional.isPresent()).isTrue();
        assertThat(actualOptional.get()).isSameAs(expectedValue);
    }

    @Test
    public void of_nullIsPassed_aNullPointerExceptionIsThrown() {
        assertThatThrownBy(() -> Optional.of(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("value");
    }

    @Test
    public void toStringMethodIsImplemented() throws NoSuchMethodException {
        Optional.class.getDeclaredMethod("toString");
    }

    @Test
    public void equals_indicatesWhetherSomeOtherObjectIsEqualToThisOptional() {
        TestObject value1 = new TestObject("abc", 123);
        TestObject value2 = new TestObject("cba", 321);

        assertThat(Optional.empty()).isEqualTo(Optional.empty());
        assertThat(Optional.empty()).isNotEqualTo(Optional.of(value1));
        assertThat(Optional.empty()).isNotEqualTo(value1);
        assertThat(Optional.of(value1)).isEqualTo(Optional.of(new TestObject("abc", 123)));
        assertThat(Optional.of(value1)).isNotEqualTo(Optional.of(value2));
        assertThat(Optional.of(value1)).isNotEqualTo(value1);
    }

    @Test
    public void hashCode_returnsTheHashCodeValueOfThePresentValueIfAnyOrZeroIfNoValueIsPresent() {
        TestObject value = new TestObject("abc", 123);

        assertThat(Optional.empty().hashCode()).isEqualTo(0);
        assertThat(Optional.of(value).hashCode()).isEqualTo(value.hashCode());
    }

    @Value
    private static class TestObject {

        private String name;
        private int value;
    }
}
