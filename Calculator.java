public class Calculator implements CalculatorInterface {
    private CustomStack<Integer> stack;

    public Calculator() {
        this.stack = new CustomStack<>();
    }

    @Override
    public int evaluatePostfix(String expression) throws IllegalArgumentException {
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                performOperation(token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: insufficient operands or too many operators");
        }

        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void performOperation(String operator) {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Without further information, please add more operands");
        }
    
        int oper1 = stack.pop();
    
        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Without further information, please add more operands");
        }
    
        int oper2 = stack.pop();

        switch (operator) {
            case "+":
                stack.push(oper2 + oper1);
                break;
            case "-":
                stack.push(oper2 - oper1);
                break;
            case "*":
                stack.push(oper2 * oper1);
                break;
            case "/":
                if (oper1 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                stack.push(oper2 / oper1);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}