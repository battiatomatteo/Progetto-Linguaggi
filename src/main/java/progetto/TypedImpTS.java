package progetto;

import progetto.exception.CastException;
import progetto.exception.TypeMismatchException;
import progetto.exception.VarDeclarationException;
import progetto.type.*;

import java.util.HashMap;
import java.util.Map;

public class TypedImpTS extends LinguaggioBaseVisitor<Type> {

    private final Map<String, ExpType> typeMap = new HashMap<>();

    private ComType visitCom(LinguaggioParser.ComContext ctx) {
        return (ComType) visit(ctx);
    }

    private SimpleType visitBoolExp(LinguaggioParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.BOOL)) { // not boolean expression
            throw new TypeMismatchException(getError(ctx,
                    "Type mismatch: boolean expression expected."));
        }

        return SimpleType.BOOL;
    }

    private SimpleType visitStringExp(LinguaggioParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (!expType.isCompatible(SimpleType.STRING)) { // not string expression
            throw new TypeMismatchException(getError(ctx,
                    "Type mismatch: string expression expected."));
        }

        return SimpleType.STRING;
    }

    private SimpleType visitNumExp(LinguaggioParser.ExpContext ctx) {
        ExpType expType = (ExpType) visit(ctx);
        if (isNotNumericType(expType)) { // not numeric expression
            throw new TypeMismatchException(getError(ctx,
                    "Type mismatch: numeric expression expected."));
        }

        return (SimpleType) expType;
    }
    @Override
    public ExpType visitCast(LinguaggioParser.CastContext ctx) {
        ExpType type = (ExpType) visit(ctx.exp());
        String typeName = ctx.type().getText();

        ExpType result;
        if (typeName.endsWith("[]")) {
            result = ArrayType.fromString(typeName);
        } else {
            result = SimpleType.fromString(typeName);
        }

        if(!type.isCastable(result)) {
            throw new CastException(getError(ctx,
                    "Type mismatch: impossibile effettuare il casting dal tipo " + type + " a " + result));
        }
        return result;
    }



    @Override
    public ComType visitMain(LinguaggioParser.MainContext ctx) {
        visit(ctx.decl());
        return (ComType) visit(ctx.com());
    }

    private ExpType matchType(String varTypeName) {
        ExpType tmp;
        if (varTypeName.endsWith("[]")) {
            tmp = ArrayType.fromString(varTypeName);
        }
        else {
            tmp = SimpleType.fromString(varTypeName);
        }
        if (tmp == null) {
            throw new RuntimeException("Unknown type: " + varTypeName);
        }
        else  {
            return tmp;
        }
    }

    @Override
    public ComType visitDecl(LinguaggioParser.DeclContext ctx) {
            for(LinguaggioParser.VarDecContext decCtx : ctx.varDec()){
                String id = decCtx.ID().getText();
                String typeText = decCtx.type().getText();   // es: "int", "int[]", "string[]"
                ExpType varType = matchType(typeText);

            if (typeMap.containsKey(id)) {
                throw new VarDeclarationException(getError(ctx,
                        "Variable " + id + " already declared of type " + typeText ));
            }

            typeMap.put(id, varType);
            //Nuovo
            LinguaggioParser.ExpContext exp = decCtx.exp();
            if (exp != null) {
                ExpType expType = (ExpType) visit(exp);
                if (!varType.isCompatible(expType)) {
                    throw new TypeMismatchException("assigned value " + exp.getText() + " of type " +  expType + " is not compatible with type " + varType);
                }
            }

        }

        return ComType.INSTANCE;
    }

    @Override
    public ExpType visitArray(LinguaggioParser.ArrayContext ctx) {

        // caso che non si puo' verificare bloccato dal linguaggio a livello sintattico
        if (ctx.exp().isEmpty()) {
            // array vuoto → tipo sconosciuto
            return null;
        }

        ExpType first = (ExpType) visit(ctx.exp(0));

        // per evitare array annidati controllo che il primo elemento non sia un array
        if (first instanceof ArrayType) {
            throw new TypeMismatchException(getError(ctx,
                    "Array annidati non permessi"));
        }
        // tutti gli elementi devono avere lo stesso tipo
        for (int i = 1; i < ctx.exp().size(); i++) {
            ExpType t = (ExpType) visit(ctx.exp(i));
            if (!first.isCompatible(t)) {
                throw new TypeMismatchException(getError(ctx,
                       "Array elements must have the same type."));
            }
            // blocco array annidato
            /*
            if (t instanceof ArrayType) {
                throw new TypeMismatchException("Array annidati non permessi");
            }*/
        }

        // mappa tipo semplice → tipo array
        return ArrayType.fromSimpleType((SimpleType) first);
    }


    @Override
    public ComType visitArrayAssign(LinguaggioParser.ArrayAssignContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id,ctx);

        // deve essere un array
        if (!(varType instanceof ArrayType arrType)) {
            throw new TypeMismatchException(getError(ctx,
                    "Variable " + id + " is not an array."));
        }
        // tipo dell'indice
        ExpType indexType = (ExpType) visit(ctx.exp(0));
        if (!indexType.isCompatible(SimpleType.INT)) {
            throw new TypeMismatchException(getError(ctx,
                    "Array index must be int."));
        }
        // tipo del valore assegnato
        ExpType valueType = (ExpType) visit(ctx.exp(1));

        // tipo degli elementi dell'array
        SimpleType elemType = ArrayType.toSimpleType(arrType);
        if (!elemType.isCompatible(valueType)) {
            throw new TypeMismatchException(getError(ctx,
                    "Array " + id + " cannot be assigned with " + valueType.getName() + "."));
        }
        return ComType.INSTANCE;
    }


    @Override
    public ExpType visitArrayAccess(LinguaggioParser.ArrayAccessContext ctx) {
        String id = ctx.ID().getText();
        ExpType t = exists(id, ctx);

        if (!(t instanceof ArrayType arrType)) {
            throw new TypeMismatchException("Variable " + id + " is not an array.\n@" +
                    ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());
        }
        // indice deve essere int
        ExpType indexType = (ExpType) visit(ctx.exp());
        if (!indexType.isCompatible(SimpleType.INT)) {
            throw new TypeMismatchException("Array index must be int.\n@" +
                    ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());
        }
        // ritorna il tipo degli elementi
        return ArrayType.toSimpleType(arrType);
    }


    @Override
    public Type visitWhile(LinguaggioParser.WhileContext ctx) {
        visitBoolExp(ctx.exp());
        return visit(ctx.com());
    }

    @Override
    public ComType visitIf(LinguaggioParser.IfContext ctx) {
        visitBoolExp(ctx.exp());
        return visitCom(ctx.com());
    }

    @Override
    public ComType visitIfElse(LinguaggioParser.IfElseContext ctx) {
        visitBoolExp(ctx.exp());
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    private void checkAssign(LinguaggioParser.ComContext ctx, String id, ExpType varType, ExpType expType) {
        if (!varType.isCompatible(expType)) { // type mismatch
            throw new TypeMismatchException(getError(ctx,
                    "Variable " + id + " of type "+ varType +
                            " cannot be assigned with " + expType.getName() + "."));
        }
    }

    @Override
    public ComType visitIfStatement(LinguaggioParser.IfStatementContext ctx) {
        String id = ctx.ID().getText();

        ExpType varType = exists(id,ctx);

        visitBoolExp(ctx.exp(0));

        ExpType expType = (ExpType) visit(ctx.exp(1));
        checkAssign(ctx, id, varType, expType);

        ExpType exp2Type = (ExpType) visit(ctx.exp(2));
        checkAssign(ctx, id, varType, exp2Type);

        return ComType.INSTANCE;
    }

    private ExpType exists(String id, LinguaggioParser.ComContext ctx) {
        if (!typeMap.containsKey(id)) { // assignment to not declared variable
            throw new VarDeclarationException(getError(ctx,
                    "Variable " + id + " assigned but never declared."));
        }
        return typeMap.get(id);
    }

    private ExpType exists(String id, LinguaggioParser.ExpContext ctx) {
        if (!typeMap.containsKey(id)) { // assignment to not declared variable
            throw new VarDeclarationException(getError(ctx,
                    "Variable " + id + " assigned but never declared."));
        }
        return typeMap.get(id);
    }

    private String getError(LinguaggioParser.ComContext ctx, String error) {
        return error + "\n@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
    }
    private String getError(LinguaggioParser.ExpContext ctx,String error) {
        return error + "\n@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
    }
    private String getError(LinguaggioParser.DeclContext ctx,String error) {
        return error + "\n@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine() + "\n";
    }

    @Override
    public ComType visitAssign(LinguaggioParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id, ctx);
        ExpType expType = (ExpType) visit(ctx.exp());
        checkAssign(ctx, id, varType, expType);
        return ComType.INSTANCE;
    }

    @Override
    public Type visitFastAssign(LinguaggioParser.FastAssignContext ctx) {
        String id = ctx.ID().getText();

        ExpType varType = exists(id, ctx);
        if (isNotNumericType(varType)) {
            throw new TypeMismatchException(getError(ctx,
                    "Cannot use fast assigns on non numeric variable " + varType));
        }
        ExpType expType = (ExpType) visit(ctx.exp());
        checkAssign(ctx, id, varType, expType);
        return ComType.INSTANCE;
    }

    private boolean isNotNumericType(ExpType varType) {
        return (varType != SimpleType.DEC) && (varType != SimpleType.INT);
    }
    private ComType incDecCheck(ExpType varType, LinguaggioParser.ComContext ctx) {
        if (isNotNumericType(varType)) {
            throw new TypeMismatchException(getError(ctx,
                    "Cannot use increment on non numeric variable " + varType));
        }
        return ComType.INSTANCE;
    }

    private ExpType incDecCheck(ExpType varType, LinguaggioParser.ExpContext ctx) {
        if (isNotNumericType(varType)) {
            throw new TypeMismatchException(getError(ctx,
                    "Cannot use increment on non numeric variable " + varType));
            }
        return varType;
    }

    @Override
    public Type visitPostDecrInc(LinguaggioParser.PostDecrIncContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id, ctx);
        return incDecCheck(varType, ctx);
    }

    @Override
    public Type visitPreDecrInc(LinguaggioParser.PreDecrIncContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id, ctx);
        return incDecCheck(varType, ctx);
    }


    @Override
    public ExpType visitPostDecrIncExp(LinguaggioParser.PostDecrIncExpContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id, ctx);
        return incDecCheck(varType, ctx);
    }

    @Override
    public ExpType visitPreDecrIncExp(LinguaggioParser.PreDecrIncExpContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id, ctx);
        return incDecCheck(varType, ctx);
    }

    @Override
    public ComType visitSeq(LinguaggioParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ExpType visitId(LinguaggioParser.IdContext ctx) {
        String id = ctx.ID().getText();
        return exists(id,ctx);
    }

    @Override
    public ComType visitOut(LinguaggioParser.OutContext ctx) {
        visit(ctx.exp());
        return ComType.INSTANCE;
    }

    @Override
    public Type visitInput(LinguaggioParser.InputContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id, ctx);
        if (varType != SimpleType.STRING) {
            throw new TypeMismatchException("Cannot use input on non String variable but  " + id  + " is type " + varType);
        }
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitNonDet(LinguaggioParser.NonDetContext ctx) {
        for (LinguaggioParser.ComContext com : ctx.com()) {
            visitCom(com);
        }
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitNop(LinguaggioParser.NopContext ctx) {
        return ComType.INSTANCE;
    }

    private SimpleType aritmeticOperation(LinguaggioParser.ExpContext ctx, SimpleType left, SimpleType right) {
        if (left != right) {
            throw new TypeMismatchException(getError(ctx,
                    "Type mismatch: the operation cannot be applied to the given operands."));
        }
        return left;
    }
    private SimpleType logicOperation(LinguaggioParser.ExpContext ctx, ExpType left, ExpType right) {
        if (left != right) {
            throw new TypeMismatchException(getError(ctx,
                    "Type mismatch: the operation cannot be applied to the given operands."));
        }
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitMulDivMod(LinguaggioParser.MulDivModContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));
        return aritmeticOperation(ctx, left, right);
    }

    @Override
    public SimpleType visitString(LinguaggioParser.StringContext ctx) {
        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitComplexString(LinguaggioParser.ComplexStringContext ctx) {
        return SimpleType.STRING;
    }

    @Override
    public Type visitCharLiteral(LinguaggioParser.CharLiteralContext ctx) {
        return SimpleType.CHAR;
    }

    @Override
    public SimpleType visitNumeric(LinguaggioParser.NumericContext ctx) {
        return (SimpleType) visit(ctx.num());
    }

    @Override
    public SimpleType visitIntNum(LinguaggioParser.IntNumContext ctx) {
        return SimpleType.INT;
    }

    @Override
    public SimpleType visitDecNum(LinguaggioParser.DecNumContext ctx) {
        return SimpleType.DEC;
    }

    @Override
    public Type visitAddSub(LinguaggioParser.AddSubContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));
        return aritmeticOperation(ctx, left, right);
    }

    @Override
    public SimpleType visitConcat(LinguaggioParser.ConcatContext ctx) {
        visit(ctx.exp(0));
        visit(ctx.exp(1));
        return SimpleType.STRING;
    }

    @Override
    public SimpleType visitAndOr(LinguaggioParser.AndOrContext ctx) {
        visitBoolExp(ctx.exp(0));
        visitBoolExp(ctx.exp(1));
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitNot(LinguaggioParser.NotContext ctx) {
        visitBoolExp(ctx.exp());
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitEqExp(LinguaggioParser.EqExpContext ctx) {
        ExpType left = (ExpType) visit(ctx.exp(0));
        ExpType right = (ExpType) visit(ctx.exp(1));
        return logicOperation(ctx, left, right);
    }

    @Override
    public SimpleType visitBoolean(LinguaggioParser.BooleanContext ctx) {
        return SimpleType.BOOL;
    }

    @Override
    public SimpleType visitCmpExp(LinguaggioParser.CmpExpContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));
        return logicOperation(ctx, left, right);
    }

    @Override
    public ExpType visitParExp(LinguaggioParser.ParExpContext ctx) {
        return (ExpType) visit(ctx.exp());
    }

    @Override
    public SimpleType visitPow(LinguaggioParser.PowContext ctx) {
        SimpleType left = visitNumExp(ctx.exp(0));
        SimpleType right = visitNumExp(ctx.exp(1));
        return aritmeticOperation(ctx, left, right);
    }

    @Override
    public ComType visitForWithFinal(LinguaggioParser.ForWithFinalContext ctx) {
        String id = ctx.ID().getText();
        ExpType varType = exists(id,ctx);
        if (varType != SimpleType.INT) {
            throw new TypeMismatchException(getError(ctx,
                    "For must have int counters variable but " + id  + " is type " + varType));
        }
        SimpleType expType1 = visitNumExp(ctx.exp(0));
        SimpleType expType2 = visitNumExp(ctx.exp(1));
        if (expType1 != SimpleType.INT || expType2 != SimpleType.INT) {
            throw new TypeMismatchException(getError(ctx,
                    "For must have int counters variable but " +
                            ctx.exp(0).getText()  + " is type " + expType1 + "  " +
                            ctx.exp(1).getText()  + " is type " + expType2));
        }
        visitCom(ctx.com(0));
        LinguaggioParser.ComContext ctx1 = ctx.com(1);
        if(ctx1 != null){
            visitCom(ctx.com(1));
        }
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitBreakCmd(LinguaggioParser.BreakCmdContext ctx) { return ComType.INSTANCE; }

    @Override
    public ComType visitSwitchCmd(LinguaggioParser.SwitchCmdContext ctx) {
        int i = 1;
        ExpType type = (ExpType) visit(ctx.exp());
        for (LinguaggioParser.CaseBranchContext Case : ctx.switchBody().caseBranch()) {
            //System.out.println("eseguo case numero " + i + "valore" + Case.exp().getText() + "comando" + Case.com().getText() );
            visitCom(Case.com());
            ExpType typeCase = (ExpType) visit(Case.exp());
            if (!(type.isCompatible(typeCase))) {
                 throw new TypeMismatchException(getError(ctx,
                         "Errore: tipo non compatibile nel case numero : " + i));
            }
            i++;
        }

        LinguaggioParser.DefaultBranchContext switchDefault = ctx.switchBody().defaultBranch();
        if(switchDefault != null){
            visitCom(switchDefault.com());
        }
        return ComType.INSTANCE;
    }

    @Override
    public ComType visitExit(LinguaggioParser.ExitContext ctx) {
        return ComType.INSTANCE;
    }
}