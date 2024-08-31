package com.oaklandgrp.recruitment.java.expressions;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.oaklandgrp.recruitment.java.expressions.ExpressionFactory.*;

@RunWith(JUnit4.class)
public class ExpressionTest {

    /**
     * 3 + 4 * 5 = 23
     */
    @Test
    public void shouldReturn23() {
        final Expression expression = add(literal(3), multiply(literal(4), literal(5)));

        Assertions.assertThat(TestUtils.evaluate(expression)).isEqualTo(23);
        Assertions.assertThat(TestUtils.format(expression)).isEqualTo("(+ 3 (* 4 5))");
    }

    /**
     * (3 + 4) * 5 = 35
     */
    @Test
    public void shouldReturn35() {
        final Expression expression = multiply(add(literal(3), literal(4)), literal(5));

        Assertions.assertThat(TestUtils.evaluate(expression)).isEqualTo(35);
        Assertions.assertThat(TestUtils.format(expression)).isEqualTo("(* (+ 3 4) 5)");
    }

    /**
     * 1 + 2 * 3 + 4 = 11
     */
    @Test
    public void shouldReturn11() {
        final Expression expression = add(literal(1), multiply(literal(2), literal(3)), literal(4));

        Assertions.assertThat(TestUtils.evaluate(expression)).isEqualTo(11);
        Assertions.assertThat(TestUtils.format(expression)).isEqualTo("(+ 1 (* 2 3) 4)");
    }

    /**
     * 8 = 8
     */
    @Test
    public void shouldReturn8() {
        final Expression expression = literal(8);

        Assertions.assertThat(TestUtils.evaluate(expression)).isEqualTo(8);
        Assertions.assertThat(TestUtils.format(expression)).isEqualTo("8");
    }

    /**
     * 1 + 2 + 3 + 4 = 10
     */
    @Test
    public void shouldReturn10() {
        final Expression expression = add(literal(1), literal(2), literal(3), literal(4));

        Assertions.assertThat(TestUtils.evaluate(expression)).isEqualTo(10);
        Assertions.assertThat(TestUtils.format(expression)).isEqualTo("(+ 1 2 3 4)");
    }
    

}
