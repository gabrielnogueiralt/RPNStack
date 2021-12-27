package postfix.interpreter;

import postfix.ast.Expr;

public class SemanticExcepiton extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SemanticExcepiton(Expr.Id expr) {
        super(expr.value + " cannot be resolved");
    }
}
