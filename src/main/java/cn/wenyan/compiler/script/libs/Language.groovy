package cn.wenyan.compiler.script.libs

import cn.wenyan.compiler.GroovyCompiler
import cn.wenyan.compiler.LanguageCompiler
import cn.wenyan.compiler.lib.ArrayUtils
import cn.wenyan.compiler.lib.Define
import cn.wenyan.compiler.lib.Defines
import cn.wenyan.compiler.lib.JSArray
import cn.wenyan.compiler.lib.WenYanException

enum Language {

    GROOVY(
            [
                    (Syntax.VAR_DEFINE)           : "def $NAME = $VALUE",
                    (Syntax.FOR_NUMBER)            : "for(_ans$INDEX in 1..$RANGE){",
                    (Syntax.COMMENT)               : "/*$COMMENT*/",
                    (Syntax.FOR_EACH)              : "for($ELEMENT in $ARRAY){",
                    (Syntax.FOR_END)               : "}",
                    (Syntax.IF)                    : "if($BOOL){",
                    (Syntax.IF_END)               : "}",
                    (Syntax.IF_BREAK)              : "if($BOOL)break",
                    (Syntax.WHILE_TRUE)            : "while(true){",
                    (Syntax.ELSE)                  : "}else{",
                    (Syntax.BREAK)                 : "break",
                    (Syntax.RETURN)                : "return $VALUE",
                    (Syntax.FUNCTION_END)          : "}",
                    (Syntax.DEFINE_FUNCTION)       : "def $NAME($ARGS){",
                    (Syntax.FUNCTION_ARGS_SPLIT)   : ",",
                    (Syntax.IMPORT)                : "import $LIB",
                    (Syntax.IMPORT_STATIC)         : "import static $LIB.$METHOD",
                    (Syntax.IMPORT_STATIC_SEPARATE): "true",
                    (Syntax.IMPORT_SPLIT)          : "null",
                    (Syntax.MATH_ADD)              : "+",
                    (Syntax.MATH_LESS)             : "-",
                    (Syntax.MATH_MULTI)            : "*",
                    (Syntax.MATH_EXCEPT)           : "/",
                    (Syntax.MATH_REMAIN)           : "%",
                    (Syntax.BIGGER)                : ">",
                    (Syntax.SMALLER)               : "<",
                    (Syntax.EQUAL)                 : "==",
                    (Syntax.AND)                  : "&&",
                    (Syntax.OR)                    : "||",
                    (Syntax.PRINT)                 : "println($VALUE)",
                    (Syntax.NEGATE)                : "!",
                    (Syntax.CHANGE)                : "$NAME = $VALUE",
                    (Syntax.REPLACE_ARRAY)         : "$NAME[getIndex($INDEX)] = $VALUE",
                    (Syntax.STRING)                : "\"",
                    (Syntax.ARRAY_ADD)             : NAME+".add($VALUE)",
                    (Syntax.INNER_FUNCTION)        : "def $NAME = {\n $ARGS->",
                    (Syntax.INNER_FUNCTION_NO_ARGS): "def $NAME = {\n ",
                    (Syntax.TRUE)                  : "true",
                    (Syntax.FALSE)                 : "false",
                    (Syntax.NOT_BIG_THAN)          : "<=",
                    (Syntax.NOT_SMALL_THAN)        : ">=",
                    (Syntax.NEGATE_EQUAL)          : "!=",
                    (Syntax.SLICE)                 : "getArray($NAME).slice(1)",
                    (Syntax.SIZE)                  : "getArray($NAME).size()",
                    (Syntax.RUN_FUNCTION)          : "def $VALUE = $NAME($ARGS)",
                    (Syntax.OBJECT_INNER)          : ".",
                    (Syntax.NUMBER_SUGAR)          : "((Integer)$NAME)",
                    (Syntax.STRING_APPEND)         : "+",
                    (Syntax.ARRAY_GET)             : "getArray($NAME)[getIndex($INDEX)]",
                    (Syntax.INT_TYPE)              : "int",
                    (Syntax.STRING_TYPE)           : "String",
                    (Syntax.ARRAY_TYPE)            : "JSArray",
                    (Syntax.BOOL_TYPE)             : "boolean",
                    (Syntax.VAR_TYPE)              : "def",
                    (Syntax.DOUBLE_TYPE)           : "double",
                    (Syntax.FUNCTION_ARG_DEFINE)   : "$NAME",
                    (Syntax.NULL)                  : "null",
                    (Syntax.DEFINE_ARRAY)          : "new JSArray()",
                    (Syntax.DEFINE_INT)            : "0",
                    (Syntax.DEFINE_STRING)         : "''",
                    (Syntax.IMPORT_WITH)           : ("import "+ JSArray.name+"\nimport static "+ArrayUtils.name+".getArray\nimport static "+ArrayUtils.name+".getIndex\nimport "+ Define.name+"\nimport "+ Defines.name),
                    (Syntax.NOT)                   : "!",
                    (Syntax.REQUIRE_SCRIPT)        : "",
                    (Syntax.CONTINUE)              : "continue",
                    (Syntax.ELSE_IF)               : "}else ",
                    (Syntax.CONCAT)                : (NAME+".putAll($VALUE)"),
                    (Syntax.TRY)                   : "try{",
                    (Syntax.THROW)                 : ("Exception $NAME = new Exception($EXCEPTION)\nthrow $NAME"),
                    (Syntax.CATCH)                 : "}catch($NAME){",
                    (Syntax.EXCEPTION_IF)          : (NAME+".message.equals($EXCEPTION)"),
                    (Syntax.CATCH_END)             : "}\n}",
                    (Syntax.SHELL_VAR)             : "$NAME = $VALUE"
            ],new GroovyCompiler()
    );

    static final String EXCEPTION ="%{exception}%"

    static final String TYPE = "%{type}%"

    static final String NAME = "%{name}%"

    static final String VALUE = "%{value}%"

    static final String INDEX = "%{index}%"

    static final String RANGE = "%{range}%"

    static final String COMMENT = "%{comment}%"

    static final String ELEMENT = "%{element}%"

    static final String ARRAY = "%{array}%"

    static final String BOOL = "%{bool}%"

    static final String ARGS = "%{args}%"

    static final String LIB = "%{lib}%"

    static final String METHOD = "%{method}%"


    protected Map<Syntax,String> syntaxLib

    protected LanguageCompiler compiler

    Language(syntaxLib,compiler){
        this.syntaxLib = syntaxLib
        this.compiler = compiler
    }

    String getSyntax(Syntax property){
        return syntaxLib[property]
    }

    LanguageCompiler languageCompiler(){
        return compiler
    }
}
