package com.oaklandgrp.recruitment.java.expressions;

import java.util.Arrays;

public class ExpressionFactory {

    public static Expression literal(final int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String format() {
                return String.valueOf(value);
            }
        };
    }

    public static Expression add(final Expression... expressions) {
        if (expressions == null) {
            throw new IllegalArgumentException("Expression array cannot be null.");
        }
        if (expressions.length < 2) {
            throw new IllegalArgumentException("At least two expressions must be provided for addition.");
        }
        for (Expression expr : expressions) {
            if (expr == null) {
                throw new IllegalArgumentException("Null expressions are not allowed.");
            }
        }
        return new Expression() {
            @Override
            public int evaluate() {
                return Arrays.stream(expressions)
                             .mapToInt(Expression::evaluate)
                             .sum();
            }

            @Override
            public String format() {
                return "(+ " + Arrays.stream(expressions)
                                     .map(Expression::format)
                                     .reduce((a, b) -> a + " " + b)
                                     .orElse("") + ")";
            }
        };
    }

    public static Expression multiply(final Expression... expressions) {
        if (expressions == null) {
            throw new IllegalArgumentException("Expression array cannot be null.");
        }
        if (expressions.length < 2) {
            throw new IllegalArgumentException("At least two expressions must be provided for multiplication.");
        }
        for (Expression expr : expressions) {
            if (expr == null) {
                throw new IllegalArgumentException("Null expressions are not allowed.");
            }
        }
        return new Expression() {
            @Override
            public int evaluate() {
                return Arrays.stream(expressions)
                             .mapToInt(Expression::evaluate)
                             .reduce(1, (a, b) -> a * b);
            }

            @Override
            public String format() {
                return "(* " + Arrays.stream(expressions)
                                     .map(Expression::format)
                                     .reduce((a, b) -> a + " " + b)
                                     .orElse("") + ")";
            }
        };
    }
}
