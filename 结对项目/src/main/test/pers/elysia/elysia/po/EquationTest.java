package pers.elysia.elysia.po;

import pers.elysia.elysia.po.*;
import org.junit.Before;
import pers.elysia.elysia.exception.OperandException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EquationTest {
    Equation equation;
    Equation equation1;
    List<Arithmetic> list;
    @Before
    public void start() throws OperandException {
        list = new ArrayList<>();
        list.add(new Operand(0,"1"));
        list.add(Operator.MINUS);
        list.add(new Operand(0,"2"));
        list.add(Operator.PLUS);
        list.add(new Operand(0,"3"));
        equation = new Equation(list);

        list.clear();

        list.add(new Operand(0,"3"));
        list.add(Operator.PLUS);
        list.add(Brackets.LEFT_BRACKET);
        list.add(new Operand(0,"2"));
        list.add(Operator.PLUS);
        list.add(new Operand(0,"1"));
        list.add(Brackets.RIGHT_BRACKET);
        equation1 = new Equation(list);
    }

    @Test
    public void testInfixToPostfix() throws OperandException {
        System.out.println(equation.infixToPostfix());
        System.out.println(equation1.infixToPostfix());
    }
    @Test
    public void testGenerate(){
        for(int i=0;i<10;i++) {
            equation = Equation.generate(3, 2, 0, 1, 10);
            System.out.println(equation.toString() + "的结果是" + equation.getResult());

        }
    }

    @Test
    public void testCalculate() throws OperandException {
        System.out.println(equation.calculate());
    }

    @Test
    public void testFilter() throws OperandException {
        List<Equation> ll = new ArrayList<>();
        ll.add(equation);
        ll.add(equation1);

        for(Equation e : ll){
            System.out.println(e.toString());
        }
        System.out.println("过滤后");
        ll = Equation.filter(ll);
        for(Equation e : ll){
            System.out.println(e.toString());
        }
    }

    @Test
    public void testToString() throws OperandException {
        Equation equation = new Equation(list);
        System.out.println(equation.toString());
    }

    @Test
    public void getInfix() {
    }

    @Test
    public void getPostfix() {
    }

    @Test
    public void getResult() {
    }

    @Test
    public void isOf() {
    }
}