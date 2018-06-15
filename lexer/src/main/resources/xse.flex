/* XSE Grammar */
package lucbui.pkmnscripter.flex;

import lucbui.pkmnscripter.language.LexToken;
import lucbui.pkmnscripter.language.LexType;

/**
    * This class is a simple example lexer.
    */
%%

%class XseLexer
%unicode
%line
%column

%{
    StringBuffer string = new StringBuffer();

    private LexToken symbol(LexType type) {
    return new LexToken(type, yyline, yycolumn);
    }
    private LexToken symbol(LexType type, Object value) {
    return new LexToken(type, yyline, yycolumn, value);
    }
%}

%function nextToken
%type LexToken
%eofval{
    return symbol(LexType.EOF);
%eofval}
%debug

%%

/* keywords */
<YYINITIAL> "abstract"           { return symbol(LexType.COMMAND); }

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                    yytext()+">"); }