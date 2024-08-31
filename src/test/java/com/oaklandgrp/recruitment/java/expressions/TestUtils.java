package com.oaklandgrp.recruitment.java.expressions;

abstract class TestUtils {

    private TestUtils() {
    }

    static int evaluate(final Expression expression) {
        return expression.evaluate();
    }

    static String format(final Expression expression) {
        return expression.format();
    }
}
