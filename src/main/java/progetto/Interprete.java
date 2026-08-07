package progetto;

import progetto.exception.*;
import progetto.type.ArrayType;
import progetto.type.ExpType;
import progetto.type.SimpleType;
import progetto.value.*;
import org.apache.commons.text.StringEscapeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Interprete extends LinguaggioBaseVisitor<Value>{

    private final Mem mem;

    public Interprete() {
        this.mem = new Mem();
    }

    public Mem getMem() {
        return mem;
    }

    private ComValue visitCom(LinguaggioParser.ComContext ctx) {
        return (ComValue) visit(ctx);
    }

    private ExpValue<?> visitExp(LinguaggioParser.ExpContext ctx) {
        return (ExpValue<?>) visit(ctx);
    }

    private NumValue<?> visitNumExp(LinguaggioParser.ExpContext ctx) {
        return (NumValue<?>) visitExp(ctx);
    }

    private BoolValue visitBoolExp(LinguaggioParser.ExpContext ctx) {
        return (BoolValue) visitExp(ctx);
    }

    private StringValue visitStringExp(LinguaggioParser.ExpContext ctx) {
        return (StringValue) visitExp(ctx);
    }

    private double unwrapToDouble(NumValue<?> numValue) {
        return numValue.toJavaValue().doubleValue();
    }

    @Override
    public Value visitCast(LinguaggioParser.CastContext ctx) {
        ExpValue<?> value = visitExp(ctx.exp());
        // controllo extra
        ExpType type = ExpType.fromValue(value);
        if (type == null) {
            throw new TypeMismatchException("Il tipo di " + value + "non esiste");
        }
        String destType = ctx.type().getText();

        ExpType tp;
        if (destType.endsWith("[]")) {
            tp = ArrayType.fromString(destType);
        } else {
            tp = SimpleType.fromString(destType);
        }

        ExpValue<?> tmp = value.cast(tp);
        if (tmp == null) {
            throw new CastException("impossibile convertire dal tipo " + ExpType.fromValue(value)+ " al tipo " + tp);
        }
        return tmp;

    }

    @Override
    public ComValue visitMain(LinguaggioParser.MainContext ctx) {
        visit(ctx.decl());
        return visitCom(ctx.com());
    }

    @Override
    public ComValue visitDecl(LinguaggioParser.DeclContext ctx) {

        for (LinguaggioParser.VarDecContext decCtx : ctx.varDec()) {
            String id = decCtx.ID().getText();
            String typeText = decCtx.type().getText();
            ExpType t;
            if (typeText.endsWith("[]")) {
                // array
                t = ArrayType.fromString(typeText);
            } else {
                // tipo semplice
                t = SimpleType.fromString(typeText);
            }
            mem.add(id, t);
            //Nuovo
            LinguaggioParser.ExpContext exp = decCtx.exp();
            if(exp != null){
                ExpValue<?> val = visitExp(exp);
                mem.updateValue(id,val);
            }
        }
        return ComValue.INSTANCE;
    }


    @Override
    public ComValue visitIf(LinguaggioParser.IfContext ctx) {
        return visitBoolExp(ctx.exp()).toJavaValue()
                ? visitCom(ctx.com())
                : ComValue.INSTANCE;
    }

    @Override
    public ComValue visitIfElse(LinguaggioParser.IfElseContext ctx) {
        return visitBoolExp(ctx.exp()).toJavaValue()
                ? visitCom(ctx.com(0))
                : visitCom(ctx.com(1));
    }

    @Override
    public ExpValue<?> visitIfStatement(LinguaggioParser.IfStatementContext ctx) {
        BoolValue cond = visitBoolExp(ctx.exp(0));
        if (cond.toJavaValue()) {
            return visitExp(ctx.exp(1));
        } else {
            return visitExp(ctx.exp(2));
        }
    }

    @Override
    public ComValue visitAssign(LinguaggioParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());
        mem.updateValue(id, v);
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitFastAssign(LinguaggioParser.FastAssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());
        double val;
        NumValue<?> num = (NumValue<?>) mem.getValue(id);
        switch (ctx.op.getType()) {
            case LinguaggioParser.ADDEQ -> val = unwrapToDouble(num) + unwrapToDouble((NumValue<?>) v);
            case LinguaggioParser.SUBEQ -> val = unwrapToDouble(num) - unwrapToDouble((NumValue<?>) v);
            case LinguaggioParser.MULEQ -> val = unwrapToDouble(num) * unwrapToDouble((NumValue<?>) v);
            case LinguaggioParser.DIVEQ -> val = unwrapToDouble(num) / unwrapToDouble((NumValue<?>) v);
            default -> throw new TypeMismatchException("Type mismatch");
        }
        if (SimpleType.fromValue(num) == SimpleType.INT)
            mem.updateValue(id, new IntValue((int) val) );
        else mem.updateValue(id, new DecValue(val));
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitPostDecrInc(LinguaggioParser.PostDecrIncContext ctx) {
        String id = ctx.ID().getText();
        int op = ctx.op.getType();
        NumValue<?> num = (NumValue<?>) mem.getValue(id);
        visitIncDec(id,op,num);
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitPreDecrInc(LinguaggioParser.PreDecrIncContext ctx) {
        String id = ctx.ID().getText();
        int op = ctx.op.getType();
        NumValue<?> num = (NumValue<?>) mem.getValue(id);
        visitIncDec(id,op,num);
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitPostDecrIncExp(LinguaggioParser.PostDecrIncExpContext ctx) {
        String id = ctx.ID().getText();
        int op = ctx.op.getType();
        NumValue<?> num = (NumValue<?>) mem.getValue(id);
        visitIncDec(id,op,num);
        return num;
    }

    @Override
    public Value visitPreDecrIncExp(LinguaggioParser.PreDecrIncExpContext ctx) {
        String id = ctx.ID().getText();
        int op = ctx.op.getType();
        NumValue<?> num = (NumValue<?>) mem.getValue(id);
        return visitIncDec(id,op,num);
    }

    private NumValue<?> visitIncDec(String id, int op, NumValue<?> num) {
        double val;
        switch (op) {
            case LinguaggioParser.INCR -> val = unwrapToDouble(num) + 1;
            case LinguaggioParser.DECR -> val = unwrapToDouble(num) - 1;
            default -> throw new TypeMismatchException("Type mismatch");
        }
        NumValue<?> res;
        if (SimpleType.fromValue(num) == SimpleType.INT){
            res = new IntValue((int) val);
            mem.updateValue(id, res);
        }
        else{
            res = new DecValue(val);
            mem.updateValue(id, res);
        }
        return res;
    }

    /**
     * Leggere il nome dell’array
     * recuperarlo dalla memoria
     * verificare che sia davvero un array
     * valutare l’indice
     * valutare il valore da assegnare
     * aggiornare l’array
     * @param ctx the parse tree
     * @return
     */
    @Override
    public ComValue visitArrayAssign(LinguaggioParser.ArrayAssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> arrVal = mem.getValue(id);

        if (!(arrVal instanceof ArrayValue<?> array)) {
            throw new TypeMismatchException(id + " non è un array");
        }

        ExpValue<?> indexVal = visitExp(ctx.exp(0));
        if (!(indexVal instanceof IntValue idx)) {
            throw new TypeMismatchException("Indice non intero");
        }

        int index = idx.toJavaValue();
        ExpValue<?> value = visitExp(ctx.exp(1));
        ArrayList<ExpValue<?>> list = (ArrayList<ExpValue<?>>) array.toJavaValue();

        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Indice fuori dai limiti: " + index);
        }
        list.set(index, value);
        return ComValue.INSTANCE;
    }
    /**
     * Creare un nuovo ArrayValue
     * visitare ogni espressione interna
     * aggiungerla all’array
     * @param ctx the parse tree
     * @return
     */
    @Override
    public ArrayValue<?> visitArray(LinguaggioParser.ArrayContext ctx) {
        ArrayValue<ExpValue<?>> array = new ArrayValue<>();
        ArrayList<ExpValue<?>> list = array.toJavaValue();
        for (var expCtx : ctx.exp()) {
            list.add(visitExp(expCtx));
        }
        return array;
    }

    /**
     * Questa funzione deve restituire un elemento dell'array
     * @param ctx the parse tree
     * @return
     */
    @Override
    public ExpValue<?> visitArrayAccess(LinguaggioParser.ArrayAccessContext ctx) {
        // 1) Valuto l’espressione dell’array
        String arrayID = ctx.ID().getText();
        ExpValue<?> arr = mem.getValue(arrayID);
        if (!(arr instanceof ArrayValue<?> checkedArray)) {
            throw new TypeMismatchException("Non è un array");
        }
        if(mem.contains(arrayID)){
            // 2) Valuto l’indice
            ExpValue<?> indexVal = visitExp(ctx.exp());
            // vedere se va con le variabili, forse accetta solo valori int
            if (!(indexVal instanceof IntValue idx)) {
                throw new TypeMismatchException("Indice dell'array non è un intero");
            }
            int index = idx.toJavaValue();
            ArrayList<?> array = checkedArray.toJavaValue();
            // 3) Controllo bounds
            if (index < 0 || index >= array.size()) {
                throw new IndexOutOfBoundsException("Indice fuori dai limiti: " + index);
            }
            // 4) Restituisco l’elemento
            // probabile che si rompa per il casting
            return (ExpValue<?>) array.get(index);
        }
        else {
            throw new NameErrorException("Errore, la variabile : " + arrayID + " non esiste. ");
        }

    }

    @Override
    public ComValue visitForWithFinal(LinguaggioParser.ForWithFinalContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> expValue1 = visitNumExp(ctx.exp(0));
        ExpValue<?> expValue2 = visitNumExp(ctx.exp(1));
        int i = (int) expValue1.toJavaValue();
        int j = (int) expValue2.toJavaValue();

        for(; i < j; i++){
            mem.updateValue(id, new IntValue(i));
            ComValue val = visitCom(ctx.com(0));
            if(val instanceof ComBreak){
                break;
            }
        }
        if(!(i < j)){
            LinguaggioParser.ComContext ctx1 = ctx.com(1);
            if(ctx1 != null){
                visitCom(ctx1);
            }
        }
        return ComValue.INSTANCE;
    }

    @Override public ComValue visitBreakCmd(LinguaggioParser.BreakCmdContext ctx) {
        return ComBreak.INSTANCE;
    }

    @Override public ComValue visitSwitchCmd(LinguaggioParser.SwitchCmdContext ctx) {
        ExpValue<?> value = visitExp(ctx.exp());
        for (LinguaggioParser.CaseBranchContext Case : ctx.switchBody().caseBranch()){
            ExpValue<?> caseValue = visitExp(Case.exp());
            if(value.equals(caseValue)){
                return visitCom(Case.com());
            }
        }
        try{
            return (ComValue) visit(ctx.switchBody().defaultBranch().com());
        }catch(Exception e) {
            throw new SyntaxErrorException("No matching case and no default branch found");
        }
    }

    @Override
    public ComValue visitSeq(LinguaggioParser.SeqContext ctx) {
        ComValue first = visitCom(ctx.com(0));
        if(first instanceof ComBreak){
            return first;
        }
        return visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitWhile(LinguaggioParser.WhileContext ctx) {
        while (visitBoolExp(ctx.exp()).toJavaValue()) {
            ComValue res = visitCom(ctx.com());
            if (res instanceof ComBreak) {
                break;
            }
        }
        return ComValue.INSTANCE;
    }


    @Override
    public ComValue visitOut(LinguaggioParser.OutContext ctx) {
        System.out.println(visit(ctx.exp()).toString());
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitNop(LinguaggioParser.NopContext ctx) {
        return ComValue.INSTANCE;
    }

    @Override
    public NumValue<?> visitNumeric(LinguaggioParser.NumericContext ctx) {
        return (NumValue<?>) visit(ctx.num());
    }

    @Override
    public IntValue visitIntNum(LinguaggioParser.IntNumContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public DecValue visitDecNum(LinguaggioParser.DecNumContext ctx) {
        return new DecValue(Double.parseDouble(ctx.DEC().getText()));
    }

    @Override
    public BoolValue visitBoolean(LinguaggioParser.BooleanContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public StringValue visitString(LinguaggioParser.StringContext ctx) {
        String str = ctx.STRING().getText();
        str = str.substring(1, str.length() - 1);
        return new StringValue(StringEscapeUtils.unescapeJava(str));
    }

    @Override
    public StringValue visitComplexString(LinguaggioParser.ComplexStringContext ctx) {
        String str = visitExp(ctx.exp()).toJavaValue().toString();
        return new StringValue(StringEscapeUtils.unescapeJava(str));
    }

    @Override
    public Value visitCharLiteral(LinguaggioParser.CharLiteralContext ctx) {
        String text = ctx.CHAR().getText();
        char value = text.charAt(1);
        return new CharValue(value);
    }

    @Override
    public ExpValue<?> visitParExp(LinguaggioParser.ParExpContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public ExpValue<?> visitPow(LinguaggioParser.PowContext ctx) {
        NumValue<?> base = visitNumExp(ctx.exp(0));
        NumValue<?> exponent = visitNumExp(ctx.exp(1));

        if(unwrapToDouble(base) == 0.0){
            throw new ArithmeticException("Exponential base cannot be zero");
        }

        double result = Math.pow(unwrapToDouble(base), unwrapToDouble(exponent));
        if (SimpleType.fromValue(base) == SimpleType.INT) return new IntValue((int) result);
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitNot(LinguaggioParser.NotContext ctx) {
        return new BoolValue(!visitBoolExp(ctx.exp()).toJavaValue());
    }

    @Override
    public ExpValue<?> visitMulDivMod(LinguaggioParser.MulDivModContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));
        if(ctx.op.getType() == LinguaggioParser.DIV ||  ctx.op.getType() == LinguaggioParser.MOD){
            if(unwrapToDouble(right) == 0.0){
                throw new ArithmeticException("Division by zero");
            }
        }
        Double result;
        switch (ctx.op.getType()) {
            case LinguaggioParser.DIV -> result = unwrapToDouble(left) / unwrapToDouble(right);
            case LinguaggioParser.MUL -> result = unwrapToDouble(left) * unwrapToDouble(right);
            case LinguaggioParser.MOD -> result = unwrapToDouble(left) % unwrapToDouble(right);
            default -> result = null; // unreachable code
        }
        assert result != null; // always true
        if (SimpleType.fromValue(left) == SimpleType.INT) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public ComValue visitInput(LinguaggioParser.InputContext ctx) {
        String id = ctx.ID().getText();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        mem.updateValue(id,new StringValue(s));
        return ComValue.INSTANCE;
    }

    @Override
    public Value visitNonDet(LinguaggioParser.NonDetContext ctx) {
        List<LinguaggioParser.ComContext> coms = ctx.com();
        Random r = new Random();
        int i = r.nextInt(0,coms.size());
        visitCom(coms.get(i));
        return ComValue.INSTANCE;
    }

    @Override
    public ExpValue<?> visitAddSub(LinguaggioParser.AddSubContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));
        Double result;
        switch (ctx.op.getType()) {
            case LinguaggioParser.ADD -> result = unwrapToDouble(left) + unwrapToDouble(right);
            case LinguaggioParser.SUB -> result = unwrapToDouble(left) - unwrapToDouble(right);
            default -> result = null; // unreachable code
        }
        assert result != null; // always true
        if (SimpleType.fromValue(left) == SimpleType.INT) return new IntValue((int) result.doubleValue());
        else return new DecValue(result);
    }

    @Override
    public BoolValue visitEqExp(LinguaggioParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));
        return switch (ctx.op.getType()) {
            case LinguaggioParser.EQQ -> new BoolValue(left.equals(right));
            case LinguaggioParser.NEQ -> new BoolValue(!left.equals(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public ExpValue<?> visitId(LinguaggioParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return mem.getValue(id);
    }

    @Override
    public BoolValue visitCmpExp(LinguaggioParser.CmpExpContext ctx) {
        NumValue<?> left = visitNumExp(ctx.exp(0));
        NumValue<?> right = visitNumExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case LinguaggioParser.GEQ -> new BoolValue(unwrapToDouble(left) >= unwrapToDouble(right));
            case LinguaggioParser.LEQ -> new BoolValue(unwrapToDouble(left) <= unwrapToDouble(right));
            case LinguaggioParser.LT -> new BoolValue(unwrapToDouble(left) < unwrapToDouble(right));
            case LinguaggioParser.GT -> new BoolValue(unwrapToDouble(left) > unwrapToDouble(right));
            default -> null; // unreachable code
        };
    }

    @Override
    public BoolValue visitAndOr(LinguaggioParser.AndOrContext ctx) {
        BoolValue left = visitBoolExp(ctx.exp(0));
        BoolValue right = visitBoolExp(ctx.exp(1));

        return switch (ctx.op.getType()) {
            case LinguaggioParser.AND -> new BoolValue(left.toJavaValue() && right.toJavaValue());
            case LinguaggioParser.OR -> new BoolValue(left.toJavaValue() || right.toJavaValue());
            default -> null;
        };
    }

    @Override
    public StringValue visitConcat(LinguaggioParser.ConcatContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));

        return new StringValue(left.toString() + right.toString());
    }

    @Override
    public ComValue visitExit(LinguaggioParser.ExitContext ctx) {
        throw new InterpreterExitException("Programma terminato");
    }
}